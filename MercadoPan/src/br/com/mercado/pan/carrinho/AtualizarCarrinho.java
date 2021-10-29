package br.com.mercado.pan.carrinho;

import java.util.List;
import java.util.Scanner;

import br.com.mercado.pan.produtos.Produto;

public class AtualizarCarrinho {
	
	public boolean VerificaItem(List<ItemCarrinho> item, Integer codigo) {
		boolean retorno = false;
		
		for(int i=0; i<item.size(); i++) {
			if(item.get(i).getCodProduto() == codigo) {
				retorno = true;
				break;
			}
		}
		return retorno;
				
	}
	
	public void AdicionarQntdItemCarrinho(Scanner scan, List<ItemCarrinho> item, List<Produto> prod) {
		//validar cod e quantidade que o usuário digitar
		Integer cod = ValidaCodItem(scan, item);
		Integer qntd = ValidaQntdAdicionar(scan, prod, cod);
		
		//adicionar quantidade do item carrinho
		Integer qntdAtual = item.get(cod).getQntd();
		item.get(cod).setQntd(qntdAtual + qntd);
		
		//atualizar o valor total do item carrinho
		Integer codProdEstoque = prod.get(cod).getCodigoProd();
		Double precoUnidItem = prod.get(codProdEstoque).getPrecoProd();
		item.get(cod).setPrecoTotal(precoUnidItem * qntd);
		
		//diminuir a quantidade em estoque
		prod.get(codProdEstoque).DiminuirQntdProduto(qntd);		
	}
	
	public void RemoverQntdItemCarrinho(Scanner scan, List<ItemCarrinho> item, List<Produto> prod) {
		//validar código que o usuário digitar
		int cod = ValidaCodItem(scan, item);
		
		//validar quantidade que o usuário digitar
		Integer qntdTotalItem = item.get(cod).getQntd();
		Integer qntd = ValidaQntdRemover(scan, cod, qntdTotalItem);
		
		Integer codProdEstoque = prod.get(cod).getCodigoProd();
		
		if(qntd < qntdTotalItem) {
			
			//remover qntd do item
			item.get(cod).setQntd(qntdTotalItem - qntd);
			
			//atualizar o valor total do item carrinho (diminuir)			
			Double precoUnidItem = prod.get(codProdEstoque).getPrecoProd();
			item.get(cod).setPrecoTotal(precoUnidItem * qntd);
			
		} else if(qntd == qntdTotalItem) {
			//remover item do carrinho
			item.remove(cod);
		}
		
		//aumentar a quantidade em estoque
		prod.get(codProdEstoque).AumentarQntdProduto(qntd);	
	
	}
	
	public Integer ValidaCodItem(Scanner scan, List<ItemCarrinho> item) {
		Integer cod;
		
		while(true) {
			System.out.print("\nDigite o código do item do carrinho: ");
			cod = scan.nextInt() - 1;
			
			if(cod < 0 || cod >  item.size() - 1)
				System.out.println("Código inválido!! Tente novamente");
			else
				return cod;
		}
	}
	
	public Integer ValidaQntdAdicionar(Scanner scan, List<Produto> prod, Integer codItemCarrinho) {
		Integer qntd;
		Integer codProd = prod.get(codItemCarrinho).getCodigoProd();
		Integer qntdEstoque = prod.get(codProd).getQntdEstoque();
		
		while(true) {
			System.out.print("Digite a quantidade a adicionar: ");
			qntd = scan.nextInt() ;
			
			if(qntd < 1 || qntd > qntdEstoque) 
				System.out.println("Quantidade inválido!! Quantidade máxima em estoque: " + qntdEstoque);
			else
				return qntd;
		}
	}
	
	public Integer ValidaQntdRemover(Scanner scan, Integer codItemCarrinho, Integer qntdTotalItem) {
		Integer qntd;
				
		while(true) {
			System.out.print("Digite a quantidade a remover: ");
			qntd = scan.nextInt() ;
			
			if(qntd < 1 || qntd > qntdTotalItem) 
				System.out.println("Quantidade inválido!! Quantidade desse item no carrinho: " + qntdTotalItem);
			else
				return qntd;
		}
	}
	
	
}
