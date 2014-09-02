package br.com.alinesoftware.mb.infra;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.alinesoftware.util.Constant;

@ManagedBean
@SessionScoped
public class LocaleController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Locale locale;

	@PostConstruct
	private void init() {
		locale = new Locale(Constant.Locale.LANGUAGE_PT, Constant.Locale.COUNTRY_BR);
	}

	public String updateLocale(String language, String country) {
		locale = new Locale(language, country);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		return Constant.Page.HOME;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
