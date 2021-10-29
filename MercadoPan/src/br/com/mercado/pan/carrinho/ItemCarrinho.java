package br.com.mercado.pan.carrinho;

public class ItemCarrinho {
	
	private Integer codProduto;
	private String nomeItem;
	private Integer qntdItemCarrinho;
	private Double precoTotalItem;	
	
	public ItemCarrinho(Integer codProduto, String nomeItem, Integer qntdItemCarrinho, Double precoTotalItem) {
		this.codProduto = codProduto;
		this.nomeItem = nomeItem;
		this.qntdItemCarrinho = qntdItemCarrinho;
		this.precoTotalItem = precoTotalItem;		
	}
	
	public Integer getCodProduto() { return codProduto; }
	public void setCodProduto(Integer codProduto) { this.codProduto = codProduto; }

	public String getNomeItem() { return nomeItem; }
	public void setNome(String nome) { this.nomeItem = nome; }
	
	public Integer getQntd() { return qntdItemCarrinho; }
	public void setQntd(Integer qntd) { this.qntdItemCarrinho = qntd; }

	public Double getPrecoTotalItem() { return precoTotalItem; }
	public void setPrecoTotal(Double precoTotalItem) { this.precoTotalItem = precoTotalItem; }
	
}
