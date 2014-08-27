package br.com.alinesoftware.model.domain.produto;

import br.com.alinesoftware.model.BaseEntity;

public class RendimentoReceita extends BaseEntity<Long> {

	private Long id;
	
	private Receita receita;
	
	private Integer quantidade;
	
	private TipoQuantidade tipoQuantidade;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
