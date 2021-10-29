package br.com.mercado.pan.produtos;

public class Produto {
	
	private Integer codigoProd;
	private String nomeProd;
	private Integer qntdEstoque;
	private Double precoProd;
	
	public Produto() {
		
	}
	
	public Produto(Integer codigoProd, String nomeProd, Integer qntdEstoque, Double precoProd) {
		this.codigoProd = codigoProd;
		this.nomeProd = nomeProd;
		this.qntdEstoque = qntdEstoque;
		this.precoProd = precoProd;
	}

	public Integer getCodigoProd() { return codigoProd; }
	public void setCodigoProd(Integer codigoProd) { this.codigoProd = codigoProd; }

	public String getNomeProd() { return nomeProd; }
	public void setNomeProd(String nomeProd) { this.nomeProd = nomeProd; }

	public Integer getQntdEstoque() { return qntdEstoque; }
	public void setQntdEstoque(Integer qntdEstoque) { this.qntdEstoque = qntdEstoque; }

	public Double getPrecoProd() { return precoProd; }
	public void setPrecoProd(Double precoProd) { this.precoProd = precoProd; }	

	public void DiminuirQntdProduto(Integer qntd) {
		this.qntdEstoque -= qntd;	
	}
	
	public void AumentarQntdProduto(Integer qntd) {
		this.qntdEstoque += qntd;
	}
	
}
