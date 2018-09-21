package leitorDeDados;

import java.math.BigDecimal;
import java.util.ArrayList;

import backEnd.EPromocoes;
import backEnd.LeveXPagueY;
import backEnd.PagueXPorY;
import backEnd.Produto;
import backEnd.Promocao;

public class FabricaObjetos {
	
	private static final String PRODUTOS = "Dados/Arquivo_dados_checkout.txt";
	private static final String PROMOCOES = "Dados/promoções.csv";

	private static ArrayList<Promocao> criarPromocoes()
	{
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		ArrayList<String> arquivo = Leitor.lerArquivo(PROMOCOES);
		
		for(int i = 1; i < arquivo.size(); i++) {
			String[] celula = arquivo.get(i).split(",");
			
			if (Leitor.regexCheck(celula[1], EPromocoes.PAGUE_X_POR_Y.getRegex())) 
			{
				int quantidadeAtivacao = Integer.parseInt(celula[3]);
				BigDecimal valorDesconto = new BigDecimal(celula[4]);
				
				promocoes.add(new PagueXPorY(new BigDecimal(0), valorDesconto, quantidadeAtivacao));
			}
			else if(Leitor.regexCheck(celula[1], EPromocoes.LEVE_X_PAGUE_Y.getRegex()))
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
			int id = Integer.parseInt(Leitor.regexSearch(linha, "(?<=id:\\ )\\d+(?=\\|)"));
			String nome = Leitor.regexSearch(linha, "(?<=descricao: )[^\\|]+(?=\\|)");
			BigDecimal valorUnitario = new BigDecimal(Leitor.regexSearch(linha, "(?<=valor: )\\d+\\.\\d{0,2}"));
			int idPromocao = Integer.parseInt(Leitor.regexSearch(linha, "(?<=promocao: )\\-*\\d+(?=\\|)"));
			
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
