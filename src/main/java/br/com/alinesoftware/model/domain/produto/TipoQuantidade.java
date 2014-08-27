package br.com.alinesoftware.model.domain.produto;

public enum TipoQuantidade {
	
	UNIDADE("Unidade", "Unidades"),
	DUZIA("D�zia", "D�zias"),
	QUILOGRAMA("KG", "KG"), 
	GRAMA("G", "G"), 
	LITRO("Litro", "Litros"),
	MILILITRO("ML", "ML"),
	COLHER_SOPA("Colher de Sopa", "Colheres de Sopa"), 
	COLHER_SOBREMESA("Colher de Sobremesa", "Colheres de Sobremesa"), 
	PITADA("Pitada", "Pitadas"), 
	XICARA_CHA("X�caras de Ch�", "X�caras de Ch�"),
	FOLHA("Folha", "Folhas"),
	DENTE("Dente", "Dentes"), 
	VIDRO("Vidro", "Vidro"),
	CAIXA("Caixa", "Caixas");
	
	private String descricao;
	
	private TipoQuantidade(String descricao, String plural) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
