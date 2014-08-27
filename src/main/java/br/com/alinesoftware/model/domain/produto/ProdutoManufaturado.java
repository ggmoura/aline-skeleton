package br.com.alinesoftware.model.domain.produto;

import br.com.alinesoftware.model.BaseEntity;

public class ProdutoManufaturado extends BaseEntity<Long> {

	private Long id;
	
	private Receita receita;
	
	@Override
	public Long getId() {
		return this.id;
	}

}
