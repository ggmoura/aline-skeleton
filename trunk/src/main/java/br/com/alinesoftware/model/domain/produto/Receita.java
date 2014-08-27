package br.com.alinesoftware.model.domain.produto;

import java.util.List;

import br.com.alinesoftware.model.BaseEntity;

public class Receita extends BaseEntity<Long> {

	private Long id;
	
	private String nome;
	
	private String modoDePreparo;
	
	private List<IngredienteQuantidade> ingredientes;
	
	private RendimentoReceita rendimentoReceita;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
