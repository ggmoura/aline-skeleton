package br.com.alinesoftware.model.infra;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candidate")
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuCandidateVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String link;
	private String description;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
