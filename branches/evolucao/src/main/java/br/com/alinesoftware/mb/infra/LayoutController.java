package br.com.alinesoftware.mb.infra;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.menu.MenuItem;

@ManagedBean
@SessionScoped
public class LayoutController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contentPage;
	private String oldController;

	public void handleClose(CloseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unit Closed", "Position:'"
				+ ((LayoutUnit) event.getComponent()).getPosition() + "'");

		addMessage(message);
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				((LayoutUnit) event.getComponent()).getPosition() + " toggled", "Status:"
						+ event.getVisibility().name());
		addMessage(message);
	}

	public void handleResize(ResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				((LayoutUnit) event.getComponent()).getPosition() + " resized", "Width:" + event.getWidth()
						+ ", Height:" + event.getHeight());

		addMessage(message);
	}

	public String getContentPage() {
		return contentPage;
	}

	public void setContentPage(String contentPage) {
		this.contentPage = contentPage;
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void displayPage(ActionEvent event) {
		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		String page = menuItem.getParams().get("page").get(0);
		String controller = menuItem.getParams().get("controller").get(0);
		setContentPage(page);
		if (oldController != null && !oldController.equals("") && !controller.equals(oldController)) {
			FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(controller);
			oldController = controller;
		}
	}

	public String getOldController() {
		return oldController;
	}

	public void setOldController(String oldBean) {
		this.oldController = oldBean;
	}

}
