package br.com.mercado.pan.main;

import br.com.mercado.pan.carrinho.*;
import br.com.mercado.pan.pagamentos.*;
import br.com.mercado.pan.produtos.*;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//instâncias das classes
		Estoque estoque = new Estoque();
		MenuMercado menuMercado = new MenuMercado();
		ProdutosMenu prodMenu = new ProdutosMenu();
		AtualizarCarrinho atualizarCarrinho = new AtualizarCarrinho();
		Carrinho carrinho = new Carrinho();
		CarrinhoMenu carrinhoMenu = new CarrinhoMenu();
		Pagamento pag = new Pagamento();
		MenuPagamento menuPag = new MenuPagamento();
		
		//Listas de produtos e itens do carrinho
		List<Produto> listaProd = estoque.getListaProdutosEstoque();
		List<ItemCarrinho> listaItem = carrinho.getItem();
		
		Integer opcaoMenu;
		
		menuMercado.LogoMercado();		
		
		do {		
			//exibir catálogo de produtos
			prodMenu.MenuProdutos(listaProd);
			//exibir e validar menu principal
			opcaoMenu = menuMercado.MenuPrincipal(scan);
			
			switch(opcaoMenu) {
				
				//adiconar item no carrinho	
				case 1: 			
					//receber e validar código do produto
					Integer codProduto = prodMenu.ValidarCodproduto(scan, listaProd) - 1;
					
					//verificar se já tem esse elem no carrinho
					boolean jaTemNoCarrinho = atualizarCarrinho.VerificaItem(listaItem, codProduto);
					
					if(jaTemNoCarrinho) {
						System.out.println("\nVocê já possui esse item no carrinho!" +
					                     "\nVá para seu carrinho para mexer nos seu produtos!!");
					} else {
						//receber e validar quantidade do produto
						Integer qntdProduto = prodMenu.ValidarQntdProduto(scan, listaProd, codProduto);
						Double pretoTotalItem = listaProd.get(codProduto).getPrecoProd() * qntdProduto;
						String nomeItem = listaProd.get(codProduto).getNomeProd();						
						//adicionar no carrinho o item selecionado
						ItemCarrinho item = new ItemCarrinho(codProduto, nomeItem, qntdProduto, pretoTotalItem);
						carrinho.AddItemCarrinho(item);
						System.out.println("\nItem adiciona ao carrinho com sucesso!!");
						//diminuir a quantidade em estoque do produto selecinado
						listaProd.get(codProduto).DiminuirQntdProduto(qntdProduto);
					}								
					break;
					
				//Exibir menu do carrinho	
				case 2:
					Integer opcaoMenuCarrinho = 0;
					
					while(opcaoMenuCarrinho != 4) {											
						
						carrinhoMenu.MenuItensCarrinhos(listaItem);
						opcaoMenuCarrinho = carrinhoMenu.MenuCarrinho(scan);						
						
						switch(opcaoMenuCarrinho) {
						    //adicionar qntd
							case 1: 
								atualizarCarrinho.AdicionarQntdItemCarrinho(scan, listaItem, listaProd);
								break;
							//remover qntd
							case 2: 
								atualizarCarrinho.RemoverQntdItemCarrinho(scan, listaItem, listaProd);
								break;
							//finalizar compra
							case 3: 
								
								if(listaItem.size() == 0) {
									System.out.println("Você não possui itens no carrrinho para finalizar compra!!");
								} else {
									Integer opcaoPag = menuPag.MenuFormaPagamento(scan);
									Double valorTotal = pag.CalcularValorTotal(listaItem);
									Double pagamento = 0d;
									Integer qntdParc;
									
									switch(opcaoPag) {
									case 1: 
										pagamento = pag.PagAVistaDinheiro(valorTotal); 
										carrinhoMenu.ImprimirNotaFiscal(listaItem, valorTotal, pagamento, 1, null);
										break;
									case 2: 
										pagamento = pag.PagAVistaCredito(valorTotal); 
										carrinhoMenu.ImprimirNotaFiscal(listaItem, valorTotal, pagamento, 2, null);
										break;
									case 3: 
										qntdParc = pag.QntdParcelas(scan);
										pagamento = pag.PagParcelado(valorTotal, qntdParc); 
										carrinhoMenu.ImprimirNotaFiscal(listaItem, valorTotal, pagamento, 3, qntdParc);
										break;
									}
									
									opcaoMenuCarrinho = 4;
									opcaoMenu = 3;		
								}
								break;
								
							//sair carrinho
							case 4: 
								System.out.println("Voltando ao menu principal!!"); 
								break;
							
							default: 
								System.out.println("Opção inválida!"); 
								break;
						}
					}
					break;
					
				//sair menu	
				case 3:
					break;
				
				default: 
					System.out.println("Opção Inválida!!"); 
					break;
			}
					
		}while(opcaoMenu != 3);
			
		scan.close();						
		
	}

}
