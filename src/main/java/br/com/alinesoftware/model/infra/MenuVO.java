package br.com.alinesoftware.model.infra;

import java.io.Serializable;

import org.primefaces.model.menu.MenuModel;

public class MenuVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String label;
	private MenuModel menuModel;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public MenuModel getMenuModel() {
		return menuModel;
	}
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

}
