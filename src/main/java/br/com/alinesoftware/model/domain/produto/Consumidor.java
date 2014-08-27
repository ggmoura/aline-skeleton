package br.com.alinesoftware.model.domain.produto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Consumidor {

	@Id
	private String nome;
	private String email;
	private Long telefone;
	private List<Produto> produtosConsumidos;

}
