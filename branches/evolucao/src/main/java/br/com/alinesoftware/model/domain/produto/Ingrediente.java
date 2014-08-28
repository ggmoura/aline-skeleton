package br.com.alinesoftware.model.domain.produto;

import br.com.alinesoftware.model.BaseEntity;

public class Ingrediente extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	@Override
	public Long getId() {
		return id;
	}
	
}
