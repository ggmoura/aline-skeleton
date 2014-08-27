package br.com.alinesoftware.model.infra;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.alinesoftware.model.BaseEntity;

@Entity
@XmlRootElement(name = "subMenu")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubMenu extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	
	@XmlElementWrapper(name = "itemsSubMenu")
	@XmlElement(name = "itemSubMenu")
	@OneToMany(mappedBy = "subMenu")
	private List<SubMenuItemSubMenu> itensSubMenus;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<SubMenuItemSubMenu> getItensSubMenus() {
		return itensSubMenus;
	}
	public void setItensSubMenus(List<SubMenuItemSubMenu> itensSubMenus) {
		this.itensSubMenus = itensSubMenus;
	}

}
