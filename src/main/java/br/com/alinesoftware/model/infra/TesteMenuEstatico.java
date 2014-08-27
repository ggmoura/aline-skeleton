package br.com.alinesoftware.model.infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class TesteMenuEstatico {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		new TesteMenuEstatico().lerXML();
	}

	private void lerXML() throws JAXBException, PropertyException, FileNotFoundException {
		MenuWrapper menuWrapper = new MenuWrapper();

		List<MenuCandidateVO> menusCandidatos = new ArrayList<MenuCandidateVO>();
		MenuCandidateVO menuCandidateVO = new MenuCandidateVO();
		menuCandidateVO.setDescription("description of menu one");
		menuCandidateVO.setLink("linkmenuone");
		menusCandidatos.add(menuCandidateVO);
		MenuCandidateVO menuCandidateVO2 = new MenuCandidateVO();
		menuCandidateVO2.setDescription("description of menu tow");
		menuCandidateVO2.setLink("linkmenutow");
		menusCandidatos.add(menuCandidateVO2);
		menuWrapper.setListCandidates(menusCandidatos);

		Menu menu = new Menu();
		menu.setLabel("label Menu");

		ItemMenu itemMenu = new ItemMenu();

		MenuItemMenu menuItemMenu = new MenuItemMenu();

		SubMenu subMenu = new SubMenu();
		List<SubMenuItemMenu> subMenuItemMenus = new ArrayList<>();
		SubMenuItemMenu subMenuItemMenu = new SubMenuItemMenu();

		ParamItemMenu paramOne = new ParamItemMenu();
		paramOne.setKey("keyone");
		paramOne.setValue("valueone");
		ParamItemMenu paramTow = new ParamItemMenu();
		paramTow.setKey("keytow");
		paramTow.setValue("valuetow");
		itemMenu.setParams(new ArrayList<ParamItemMenu>());
		itemMenu.getParams().add(paramOne);
		itemMenu.getParams().add(paramTow);

		itemMenu.setParams(new ArrayList<ParamItemMenu>());
		itemMenu.setAjax(Boolean.TRUE);
		itemMenu.setCommand("command");
		itemMenu.setIcon("icon");
		itemMenu.setLabel("label");
		itemMenu.setOncomplete("oncomplete");
		itemMenu.setTitle("title");
		itemMenu.setUpdate("update");
		itemMenu.setValue("value");
		itemMenu.setParams(new ArrayList<ParamItemMenu>());
		itemMenu.getParams().add(paramOne);
		itemMenu.getParams().add(paramTow);

		menuItemMenu.setItemMenu(itemMenu);
		menuItemMenu.setMenu(menu);

		menu.setItensMenu(new ArrayList<MenuItemMenu>());
		menu.getItensMenu().add(menuItemMenu);

		ItemMenu itemMenu2 = new ItemMenu();
		itemMenu2.setParams(new ArrayList<ParamItemMenu>());
		itemMenu2.setAjax(Boolean.TRUE);
		itemMenu2.setCommand("command_1");
		itemMenu2.setIcon("icon_1");
		itemMenu2.setLabel("label_1");
		itemMenu2.setOncomplete("oncomplete_1");
		itemMenu2.setTitle("title_1");
		itemMenu2.setUpdate("update_1");
		itemMenu2.setValue("value_1");
		itemMenu2.getParams().add(paramOne);
		itemMenu2.getParams().add(paramTow);

		MenuItemMenu menuItemMenu2 = new MenuItemMenu();
		menuItemMenu2.setItemMenu(itemMenu2);
		menuItemMenu2.setMenu(menu);

		menu.getItensMenu().add(menuItemMenu2);

		subMenu.setLabel("submenu");
		subMenu.setItensSubMenus(new ArrayList<SubMenuItemSubMenu>());
		SubMenuItemSubMenu subMenuItemSubMenu = new SubMenuItemSubMenu();
		subMenuItemSubMenu.setItemMenu(itemMenu);
		subMenu.getItensSubMenus().add(subMenuItemSubMenu);

		subMenuItemMenu.setMenu(menu);
		subMenuItemMenu.setSubMenu(subMenu);
		menu.setSubMenus(new ArrayList<SubMenuItemMenu>());
		subMenuItemMenus.add(subMenuItemMenu);

		menu.getSubMenus().add(subMenuItemMenu);

		menuWrapper.setListMenus(new ArrayList<Menu>());
		menuWrapper.getListMenus().add(menu);

		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(MenuWrapper.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(menuWrapper, System.out);
		// Write to System.out
		m.marshal(menuWrapper, new File("menu.xml"));

		Unmarshaller um = context.createUnmarshaller();
		MenuWrapper menuTemp = (MenuWrapper) um.unmarshal(new FileReader("menu.xml"));
		System.out.println(menuTemp);

		Class<?> clazz = getClass();
		ClassLoader cl = clazz.getClassLoader();
		InputStream is = cl.getResourceAsStream("menu.xml");
		MenuWrapper menuTemp2 = (MenuWrapper) um.unmarshal(is);
		System.out.println(menuTemp2);

	}
}
