package br.com.mercado.pan.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private Double precoTotalCarrinho;
	private List<ItemCarrinho> item = new ArrayList<>();
	
	public Carrinho() {
		this.precoTotalCarrinho = 0.0;
	}
	
	public Double getPrecoTotalCarrinho() { return precoTotalCarrinho; }
	public void setPrecoTotalCarrinho(Double precoTotalCarrinho) { this.precoTotalCarrinho = precoTotalCarrinho; }
	
	public List<ItemCarrinho> getItem() { return item; }
	
	public void AddItemCarrinho(ItemCarrinho item) {
		this.item.add(item);
	}

}
