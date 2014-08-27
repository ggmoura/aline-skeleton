package br.com.alinesoftware.model;

import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract T getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return Boolean.TRUE;
		}
		if (obj == null) {
			return Boolean.FALSE;
		}
		if (getClass() != obj.getClass()) {
			return Boolean.FALSE;
		}
		BaseEntity<T> other = (BaseEntity<T>) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return Boolean.FALSE;
			}
		} else if (!getId().equals(other.getId())) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
