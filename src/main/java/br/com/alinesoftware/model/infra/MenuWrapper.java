package br.com.alinesoftware.model.infra;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menuWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "menus")
	@XmlElement(name = "menu")
	private List<Menu> listMenus;

	@XmlElementWrapper(name = "candidates")
	@XmlElement(name = "candidate")
	private List<MenuCandidateVO> listCandidates;

	public List<Menu> getListMenus() {
		return listMenus;
	}

	public void setListMenus(List<Menu> listMenus) {
		this.listMenus = listMenus;
	}

	public List<MenuCandidateVO> getListCandidates() {
		return listCandidates;
	}

	public void setListCandidates(List<MenuCandidateVO> listCandidates) {
		this.listCandidates = listCandidates;
	}


}
