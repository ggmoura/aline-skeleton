package br.com.alinesoftware.mb.infra;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.primefaces.component.accordionpanel.AccordionPanel;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.xml.sax.SAXException;

import br.com.alinesoftware.model.infra.ItemMenu;
import br.com.alinesoftware.model.infra.Menu;
import br.com.alinesoftware.model.infra.MenuItemMenu;
import br.com.alinesoftware.model.infra.MenuVO;
import br.com.alinesoftware.model.infra.MenuWrapper;
import br.com.alinesoftware.model.infra.ParamItemMenu;
import br.com.alinesoftware.model.infra.SubMenuItemMenu;
import br.com.alinesoftware.model.infra.SubMenuItemSubMenu;

@ManagedBean
@SessionScoped
public class MenuController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String activeIndex;

	private List<Menu> menus;

	private List<MenuVO> models;

	@PostConstruct
	private void init() {

		try {
			loadMenuWrapper();
			convertToMenu();
		} catch (ParserConfigurationException | SAXException | IOException | JAXBException e) {
			System.out.println();
		}

	}

	private void convertToMenu() {

		MenuVO model = null;
		DefaultSubMenu firstSubmenu = null;
		Boolean possuiItemMenu = null;
		Boolean possuiSubMenu = null;
		models = new ArrayList<>();
		for (Menu menu : menus) {
			possuiItemMenu = menu.getItensMenu() != null && !menu.getItensMenu().isEmpty();
			possuiSubMenu = menu.getSubMenus() != null && !menu.getSubMenus().isEmpty();
			if (possuiItemMenu || possuiSubMenu) {
				model = new MenuVO();
				model.setLabel(menu.getLabel());
				model.setMenuModel(new DefaultMenuModel());
				if (possuiItemMenu) {
					for (MenuItemMenu menuItemMenu : menu.getItensMenu()) {
						model.getMenuModel().addElement(criarItemMenu(menuItemMenu.getItemMenu()));
					}
				}
				if (possuiSubMenu) {
					for (SubMenuItemMenu subMenu : menu.getSubMenus()) {
						if (subMenu.getSubMenu().getItensSubMenus() != null
								&& !subMenu.getSubMenu().getItensSubMenus().isEmpty()) {
							firstSubmenu = new DefaultSubMenu(subMenu.getSubMenu().getLabel());
							for (SubMenuItemSubMenu subMenuItemSubMenu : subMenu.getSubMenu().getItensSubMenus()) {
								firstSubmenu.addElement(criarItemMenu(subMenuItemSubMenu.getItemMenu()));
							}
							model.getMenuModel().addElement(firstSubmenu);							
						}
					}
				}
				if (possuiItemMenu || possuiSubMenu) {
					models.add(model);
				}
			}
		}
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<MenuVO> getModels() {
		return models;
	}

	public void setModels(List<MenuVO> models) {
		this.models = models;
	}

	private DefaultMenuItem criarItemMenu(ItemMenu itemMenu) {
		DefaultMenuItem item = new DefaultMenuItem();
		item.setTitle(itemMenu.getLabel());
		item.setValue(itemMenu.getLabel());
		item.setCommand(itemMenu.getCommand());
		item.setIcon(itemMenu.getIcon());
		if (itemMenu.getParams() != null && !itemMenu.getParams().isEmpty()) {
			for (ParamItemMenu paramItem : itemMenu.getParams()) {
				item.setParam(paramItem.getKey(), paramItem.getValue());
			}
		}
		item.setUpdate(itemMenu.getUpdate());
		item.setAjax(itemMenu.getAjax());
		item.setOncomplete(itemMenu.getOncomplete());
		return item;
	}

	private void loadMenuWrapper() throws ParserConfigurationException, SAXException, IOException, JAXBException {
		InputStream is = getArchiveMenu("META-INF/menu.xml");
		JAXBContext context = JAXBContext.newInstance(MenuWrapper.class);
		Unmarshaller um = context.createUnmarshaller();
		MenuWrapper menuTemp = (MenuWrapper) um.unmarshal(is);
		menus = menuTemp.getListMenus();

	}

	private InputStream getArchiveMenu(String archive) throws ParserConfigurationException, SAXException, IOException {
		Class<?> clazz = getClass();
		ClassLoader cl = clazz.getClassLoader();
		return cl.getResourceAsStream(archive);
	}

	public void addMessage(String summary) {  
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onTabChange(TabChangeEvent event) {
		activeIndex = ((AccordionPanel) event.getComponent()).getActiveIndex();
	}

	public String getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(String activeIndex) {
		this.activeIndex = activeIndex;
	}

}
