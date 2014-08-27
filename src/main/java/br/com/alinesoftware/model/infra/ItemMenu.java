package br.com.alinesoftware.model.infra;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.alinesoftware.model.BaseEntity;

@Entity
@XmlRootElement(name = "itemMenu")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemMenu extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	private String title;
	private String value;
	private String command;
	private String icon;
	private String update;
	private Boolean ajax;
	private String oncomplete;
	
	@XmlElementWrapper(name = "params")
	@XmlElement(name = "param")
	@OneToMany(mappedBy="itemMenu", fetch=FetchType.EAGER)
	private List<ParamItemMenu> params;

	@Override
	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public Boolean getAjax() {
		return ajax;
	}

	public void setAjax(Boolean ajax) {
		this.ajax = ajax;
	}

	public String getOncomplete() {
		return oncomplete;
	}

	public void setOncomplete(String oncomplete) {
		this.oncomplete = oncomplete;
	}

	public List<ParamItemMenu> getParams() {
		return params;
	}

	public void setParams(List<ParamItemMenu> params) {
		this.params = params;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
