package testes;

import bancoDeDados.BootStrap;
import bancoDeDados.CaixaDAO;

public class Testes {

	public static void main(String[] args) 
	{
		//Iniciando o Banco de Dados:
		BootStrap.carregarBanco();
		
		CaixaDAO caixa = new CaixaDAO();
		
		//Adicionando alguns produtos quaisquer:
		caixa.adicionaProduto(7, 1);
		caixa.adicionaProduto(8, 1);
		caixa.adicionaProduto(10, 1);
		caixa.adicionaProduto(23, 1);
		caixa.adicionaProduto(2, 1);
		caixa.adicionaProduto(47, 1);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		caixa.limparCaixa();
		
		//Adicionando 1 de cada produto:
		for(int i = 0; i < 50; i++) {
			caixa.adicionaProduto(i + 1, 1);
		}
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		caixa.limparCaixa();
		
		//Adicionando alguns produtos para ativar uma promocao:
		caixa.adicionaProduto(7, 1);
		caixa.adicionaProduto(50, 1);
		caixa.adicionaProduto(7, 1);
		caixa.adicionaProduto(10, 1);
		caixa.adicionaProduto(41, 1);
		caixa.adicionaProduto(3, 1);
		caixa.adicionaProduto(7, 1);
		caixa.adicionaProduto(26, 1);
		caixa.adicionaProduto(7, 1);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		//Removendo dois produtos 7 para anular a promocao:
		caixa.removeProduto(7, 2);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		//Adicionando mais 4 produtos 7 para adicionar a promocao 2 vezes:
		caixa.adicionaProduto(7, 4);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		caixa.limparCaixa();
		
		//Adicionando 999 produtos 23:
		caixa.adicionaProduto(23, 999);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		//Adicionando 723 produtos 42:
		caixa.adicionaProduto(42, 723);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
		//removendo 500 produtos 23:
		caixa.removeProduto(23, 500);
		
		System.out.println(caixa.toString() +
				"---------------------------------------------------------------------------\n");
		
	}
}
