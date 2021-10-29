package br.com.mercado.pan.produtos;

import java.util.List;
import java.util.Scanner;


public class ProdutosMenu {
	
	public void MenuProdutos(List<Produto> prodEstoque) {
		System.out.println("\n                  CATÁLOGO DE PRODUTOS");
		System.out.println("\n===========================================================");
		System.out.printf("  %s  \t%s \t   %s \t %s\n", "Cod.", "Produtos", "Qntd.", "Preço");
		System.out.println("===========================================================");
		for(int i=0; i<prodEstoque.size(); i++) {
			String codProdEstoque = prodEstoque.get(i).getCodigoProd().toString();                    
			String nomeProd = prodEstoque.get(i).getNomeProd();
			String qntdProdEstoque = prodEstoque.get(i).getQntdEstoque().toString();
			String precoProd = "R$" + prodEstoque.get(i).getPrecoProd().toString();
			
			System.out.printf("%s %s %s %s\n", 
					           LinhaProdutos(codProdEstoque, codProdEstoque.length(), 5), 
					           LinhaProdutos(nomeProd, nomeProd.length(), 18),
					           LinhaProdutos(qntdProdEstoque, qntdProdEstoque.length(), 7),
					           LinhaProdutos(precoProd, precoProd.length(), 10));
		}
		System.out.println("===========================================================");
	}
	
	public String LinhaProdutos(String texto, int tamTexto, int tamEspaco) {				
		String linha = "";		
		return linha+= "   " + EspacoEntreColunas(texto, tamTexto, tamEspaco);
	}
	
	public String EspacoEntreColunas(String texto, int tamTexto, int tamEspaco) {		
		for(int i=tamTexto; i<tamEspaco; i++) {
			texto += " ";
		}
		return texto+= "|";
	}
	
	public Integer ValidarCodproduto(Scanner scan, List<Produto> produtos) {
		Integer cod = 0;
		Integer totalCodigos = produtos.size();
		
		while(true) {
			System.out.print("\nDigite o código do produto: ");
			cod = scan.nextInt();
			
			if(cod < 1 || cod > totalCodigos) 
				System.out.println("Código inválido! Tente novamente");
			else 
				return cod;		
		}		
	}
		
	public Integer ValidarQntdProduto(Scanner scan, List<Produto> produtos, Integer cod) {
		Integer qntd = 0;
		Integer totalQntd = produtos.get(cod).getQntdEstoque();
		
		while(true) {
			System.out.print("Digite a quantidade do produto: ");
			qntd = scan.nextInt();
			
			if(qntd < 1 || qntd > totalQntd) 
				System.out.println("Quantidade inválida! Tente novamente\n");
			else 
				return qntd;
			
		}		
	}
	
	
	
	
}
