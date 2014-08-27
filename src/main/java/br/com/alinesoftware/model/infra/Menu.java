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
@XmlRootElement(name = "menu")
@XmlAccessorType(XmlAccessType.FIELD)
public class Menu extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	
	@XmlElementWrapper(name = "itemsMenu")
	@XmlElement(name = "itemMenu")
	@OneToMany(mappedBy="menu")
	private List<MenuItemMenu> itensMenu;
	
	@XmlElementWrapper(name = "subMenus")
	@XmlElement(name = "subMenu")
	@OneToMany(mappedBy="menu")
	private List<SubMenuItemMenu> subMenus;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<MenuItemMenu> getItensMenu() {
		return itensMenu;
	}

	public void setItensMenu(List<MenuItemMenu> itensMenu) {
		this.itensMenu = itensMenu;
	}

	public List<SubMenuItemMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenuItemMenu> subMenus) {
		this.subMenus = subMenus;
	}

}
