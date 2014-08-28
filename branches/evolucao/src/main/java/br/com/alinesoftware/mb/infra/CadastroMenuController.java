package br.com.alinesoftware.mb.infra;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroMenuController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date data;

	private String descricaoMenu;

	public CadastroMenuController() {
		System.out.println("executou o construtor");
		FacesContext facesContext = FacesContext.getCurrentInstance();

		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String vId = uiViewRoot.getId();
		System.out.println(vId);
	}

	@PostConstruct
	private void init() {
		setDescricaoMenu("Menu");
		System.out.println("Menu Controle");
	}

	public Date getData() {
		data = new Date();
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricaoMenu() {
		return descricaoMenu;
	}

	public void setDescricaoMenu(String descricaoMenu) {
		this.descricaoMenu = descricaoMenu;
	}

	public void testeAjax() {
		setDescricaoMenu(String.valueOf("Menu " + Calendar.getInstance().getTimeInMillis()));
	}

}
