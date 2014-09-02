package br.com.alinesoftware.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MessageProvider {

	private static MessageProvider instance;
	private final ResourceBundle bundle;

	private MessageProvider() {
		super();
		FacesContext context = FacesContext.getCurrentInstance();
		bundle = context.getApplication().getResourceBundle(context, "message");
	}

	static {
		instance = new MessageProvider();
	}

	public static MessageProvider getInstance() {
		return instance;
	}

	public String getValue(String key) {
		String result = null;
		try {
			result = bundle.getString(key);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}
		return result;
	}
}
