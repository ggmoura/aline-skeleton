package br.com.alinesoftware.mb.infra;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.alinesoftware.business.EMF;
import br.com.alinesoftware.model.infra.Pessoa;

@ManagedBean
@ViewScoped
public class CadastroItemMenuController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date data;

	private String descricaoMenu;

	public CadastroItemMenuController() {
		System.out.println("Item Menu");
		FacesContext facesContext = FacesContext.getCurrentInstance();

		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String vId = uiViewRoot.getId();
		System.out.println(vId);
	}

	@PostConstruct
	private void init() {
		setDescricaoMenu("Item Menu");
		System.out.println("iniciou o managed bean Item Menu ");
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
		EntityManager manager = EMF.get().createEntityManager();
		Pessoa p  = new Pessoa();
		
		p.setNome("Ísis Roque");
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println(manager);
		setDescricaoMenu(String.valueOf("Item " + p.getId()));
	}

}
