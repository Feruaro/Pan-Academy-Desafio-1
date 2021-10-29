package br.com.mercado.pan.pagamentos;

import java.util.List;
import java.util.Scanner;

import br.com.mercado.pan.carrinho.ItemCarrinho;

public class Pagamento {
	
	public Double CalcularValorTotal(List<ItemCarrinho> item) {
		Double somaTotal = 0d;
		
		for(int i=0; i<item.size(); i++) {
			Double precoItem = item.get(i).getPrecoTotalItem();
			somaTotal += precoItem;
		}
		
		return somaTotal;
	}
	
	public Double PagAVistaDinheiro(Double valorTotal) {
		//desconto de 20%	
		return valorTotal * 0.8;
	}
	
	public Double PagAVistaCredito(Double valorTotal) {
		//desconto de 10%		
		return valorTotal * 0.9;
	}
	
	public Integer QntdParcelas(Scanner scan) {
		Integer qntdParc = 0;
		
		while(true) {
			System.out.print("\nQuantidade de parcelas:"+
		                      "\n1- 2x" +
					          "\n2- 3x" +
		                      "\nDigite opção: ");
			qntdParc = scan.nextInt();
			
			if(qntdParc < 1 || qntdParc > 2) System.out.println("Opção inválida!");
			else return qntdParc;
		}	
	}
	
	public Double PagParcelado(Double valorTotal, Integer qntdParc) {
		return valorTotal / qntdParc;
	}			
		
		
	
	
	
	
}
