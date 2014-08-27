package br.com.alinesoftware.mb.infra;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@ManagedBean
@RequestScoped
public class LoginController {

	private String loginURL;
	private String logoutURL;
	private User user;

	@PostConstruct
	private void init() {
		UserService userService = UserServiceFactory.getUserService();
		user = userService.getCurrentUser();
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		setLoginURL(userService.createLoginURL(req.getRequestURI()));
		setLogoutURL(userService.createLogoutURL(req.getRequestURI()));
	}

	public String login() {
		return loginURL;
	}

	public String logout() {
		return logoutURL;
	}

	public String getLoginURL() {
		return loginURL;
	}

	public void setLoginURL(String loginURL) {
		this.loginURL = loginURL;
	}

	public String getLogoutURL() {
		return logoutURL;
	}

	public void setLogoutURL(String logoutURL) {
		this.logoutURL = logoutURL;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
