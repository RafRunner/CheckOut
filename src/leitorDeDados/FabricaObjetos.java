package leitorDeDados;

import java.math.BigDecimal;
import java.util.ArrayList;

import dominio.LeveXPagueY;
import dominio.PagueXPorY;
import dominio.Produto;
import dominio.Promocao;

public class FabricaObjetos {
	
	private static final String PRODUTOS = "dados/Arquivo_dados_checkout.txt";
	private static final String PROMOCOES = "dados/promoções.csv";

	private static ArrayList<Promocao> criarPromocoes()
	{
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		ArrayList<String> arquivo = Leitor.lerArquivo(PROMOCOES);
		
		for(int i = 1; i < arquivo.size(); i++) {
			String[] celula = arquivo.get(i).split(",");
			
			if (Leitor.regexCheck(celula[1], ERegex.PAGUE_X_POR_Y.getRegex())) 
			{
				int quantidadeAtivacao = Integer.parseInt(celula[3]);
				BigDecimal valorDesconto = new BigDecimal(celula[4]);
				
				promocoes.add(new PagueXPorY(new BigDecimal(0), valorDesconto, quantidadeAtivacao));
			}
			else if(Leitor.regexCheck(celula[1], ERegex.LEVE_X_PAGUE_Y.getRegex()))
			{
				int quantidadeAtivacao = Integer.parseInt(celula[3]);
				int valorDesconto = Integer.parseInt(celula[5]);
				
				promocoes.add(new LeveXPagueY(new BigDecimal(0), quantidadeAtivacao, valorDesconto));
			}
		}
		return promocoes;
	}
	
	public static ArrayList<Produto> criarProdutos()
	{
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> arquivo = Leitor.lerArquivo(PRODUTOS);
		ArrayList<Promocao> promocoes = criarPromocoes();
		
		for(String linha : arquivo)
		{
			int id = Integer.parseInt(Leitor.regexSearch(linha, ERegex.ID.getRegex()));
			String nome = Leitor.regexSearch(linha, ERegex.NOME.getRegex());
			BigDecimal valorUnitario = new BigDecimal(Leitor.regexSearch(linha, ERegex.VALOR_UNITARIO.getRegex()));
			int idPromocao = Integer.parseInt(Leitor.regexSearch(linha, ERegex.ID_PROMOCAO.getRegex()));
			
			Promocao promocao = null;
			if(idPromocao != -1) {
				 promocao = promocoes.get(idPromocao - 1);
				 promocao.setValorUnitario(valorUnitario);
			}
			
			produtos.add(new Produto(id, nome, valorUnitario, promocao));
		}
		
		return produtos;
	}
}
