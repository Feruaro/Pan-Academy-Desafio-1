package br.com.mercado.pan.produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
	private List<Produto> listaProdutosEstoque = new ArrayList<>();		
	
	public Estoque() {
		listaProdutosEstoque.add(new Produto(1, "Arroz - 5kg", 60, 15.50));
		listaProdutosEstoque.add(new Produto(2, "Feijão - 1kg", 100, 7.30));
		listaProdutosEstoque.add(new Produto(3, "Café - 500g", 58, 10.00));
		listaProdutosEstoque.add(new Produto(4, "Macarrão - 500g", 120, 3.25));
		listaProdutosEstoque.add(new Produto(5, "Farinha - 1kg", 150, 3.15));
		listaProdutosEstoque.add(new Produto(6, "Ovos - 1dúzia", 50, 8.50));
		listaProdutosEstoque.add(new Produto(7, "Leite - 1l", 200, 3.50));
		listaProdutosEstoque.add(new Produto(8, "Açúcar - 1kg", 140, 4.25));
		listaProdutosEstoque.add(new Produto(9, "Óleo - 1l", 98, 8.70));
		listaProdutosEstoque.add(new Produto(10, "Sal - 1kg", 115, 2.60));
	}

	
	public List<Produto> getListaProdutosEstoque() {
		return listaProdutosEstoque;
	}
	
	
	
	
	
	
}
