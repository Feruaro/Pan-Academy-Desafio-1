package br.com.mercado.pan.carrinho;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CarrinhoMenu {
	
	public void MenuItensCarrinhos(List<ItemCarrinho> item) {
		System.out.println("\n\n===========================================================");
		System.out.printf("  %s  \t%s \t   %s \t %s\n", "Cod.", "Produtos", "Qntd.", "Preço");
		System.out.println("===========================================================");
		for(int i=0; i<item.size(); i++) {
			String codProdItem = Integer.toString(i+1);                    
			String nomeItem = item.get(i).getNomeItem();
			String qntdItem = item.get(i).getQntd().toString();
			String precoTotalItem = "R$" + item.get(i).getPrecoTotalItem().toString();
			
			System.out.printf("%s %s %s %s\n", 
					           LinhaProdutos(codProdItem, codProdItem.length(), 5), 
					           LinhaProdutos(nomeItem, nomeItem.length(), 18),
					           LinhaProdutos(qntdItem, qntdItem.length(), 7),
					           LinhaProdutos(precoTotalItem, precoTotalItem.length(), 10));
		}
		System.out.println("===========================================================");
	}
	
	public String LinhaProdutos(String texto, int tamTexto, int tamEspaco) {				
		String linha = "";
		return linha += "   " + EspacoEntreColunas(texto, tamTexto, tamEspaco);
	}
	
	public String EspacoEntreColunas(String texto, int tamTexto, int tamEspaco) {		
		for(int i=tamTexto; i<tamEspaco; i++) {
			texto += " ";
		}
		return texto += "|";
	}
	
	public Integer MenuCarrinho(Scanner scan) {
		Integer opcao = 0;
		
		while(true) {
			System.out.println("\n---------- Menu carrinho de compras ----------");
			System.out.print("\n1- Adiconar quantidade" +
		                     "\n2- Remover quantidade" +
					         "\n3- Finalizar compra" +
		                     "\n4- Voltar para o menu principal"+
					         "\nDigite sua opção: ");
			opcao = scan.nextInt();
			
			if(opcao < 1 || opcao > 4) System.out.println("\nOpção inválida!");
			else return opcao;
		}
	}
	
	public void ImprimirNotaFiscal(List<ItemCarrinho> item, Double valorTotal, Double pagamento, Integer op, Integer qntdParc) {
		
		System.out.println("\n===========================================================\n");
		System.out.println("                      CUPOM FISCAL");
		MenuItensCarrinhos(item);
		System.out.printf("   Qtde. Total de Itens                            %d", item.size());
		System.out.printf("\n   Valor Total                                  R$%.2f", valorTotal);
		
		if(op == 1) {
			System.out.printf("\n   Desconto - 20%%                               R$%.2f", (valorTotal - pagamento));
			System.out.printf("\n   Valor a pagar - À vista Dinheiro             R$%.2f", pagamento);
			System.out.println("\n===========================================================");
		} else if(op == 2) {
			System.out.printf("\n   Desconto - 10%%                               R$%.2f", (valorTotal - pagamento));
			System.out.printf("\n   Valor a pagar - À vista crédito              R$%.2f", pagamento);
			System.out.println("\n===========================================================");
		} else if(op == 3) {
			
			if(qntdParc == 1) {
				System.out.printf("\n   Desconto                                     R$0.00");
				System.out.printf("\n   Valor a pagar                             2x R$%.2f", pagamento);
				System.out.println("\n===========================================================");
			} else if(qntdParc == 2) {
				System.out.printf("\n   Desconto                                     R$0.00");
				System.out.printf("\n   Valor a pagar                             3x R$%.2f", pagamento);
				System.out.println("\n===========================================================");
			}
		}
		
		System.out.printf("   Tributos Aprox. - 9%%                         R$%.2f", valorTotal * 0.09);
		System.out.printf("\n\n\n                   %s", DataFormatada());
		System.out.println("\n\n        Obrigada pela preferência!! Volte sempre :)");
	}
	
	public String DataFormatada() {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String dataFormatado = data.format(formatter);
        
        return dataFormatado;
	}
	
}
