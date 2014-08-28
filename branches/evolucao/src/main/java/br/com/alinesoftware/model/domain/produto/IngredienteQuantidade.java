package br.com.alinesoftware.model.domain.produto;

import br.com.alinesoftware.model.BaseEntity;

public class IngredienteQuantidade extends BaseEntity<Long> {

	private Long id;
	
	private Ingrediente ingrediente;
	
	private Integer quantidade;
	
	private TipoQuantidade tipoQuantidade;
	
	@Override
	public Long getId() {
		return this.id;
	}
	
}
