package br.com.alinesoftware.mb.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class TesteViewScope {

	private String teste;
	private List<Integer> integers;
	private Random random;

	@PostConstruct
	public void init() {
		integers = new ArrayList<>();
		random = new Random();
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public void testeInteger() {
		integers.add(random.nextInt());
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot uiViewRoot = context.getViewRoot();
		System.out.println(uiViewRoot);
		ViewHandler vh = context.getApplication().getViewHandler();
		UIViewRoot view = vh.createView(context, "/pages/protected/menu/cadastroMenu.jsf");
		view.initialStateMarked();
		view.setViewId("/pages/protected/menu/cadastroMenu.jsf");

		context.setViewRoot(view);
		System.out.println();
	}

	public List<Integer> getIntegers() {
		return integers;
	}

	public void setIntegers(List<Integer> integers) {
		this.integers = integers;
	}

}

