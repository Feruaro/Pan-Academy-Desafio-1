package br.com.mercado.pan.main;

import java.util.Scanner;

public class MenuMercado {
	
	public void LogoMercado() {
		System.out.println("*************************************************************");
		System.out.println("|                       MERCADO PAN                         |");
		System.out.println("*************************************************************");
	}
	
	public Integer MenuPrincipal(Scanner scan) {
		Integer opcao = 0;
		
		while(opcao < 1 || opcao > 3) {
			System.out.print("\n1- Adicionar produto ao carrinho" +
			 		         "\n2- Ir para carrinho" +
	                         "\n3- Sair" +
			                 "\nDigite sua opção: ");
			opcao = scan.nextInt();
	
			if(opcao < 1 || opcao > 3) System.out.println("Opção inválida!");
		}
		
		return opcao;
	}
	
}
