package backEnd;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import bancoDeDados.ProdutoDAO;
import bancoDeDados.PromocaoDAO;

public class Testes {

	public static void main(String[] args) throws SQLException
	{
		//ProdutoDAO.inserirProduto(new Produto(1, "Macarrão", new BigDecimal("10.50"), new ArrayList<Promocao>()));
		
		Produto teste = ProdutoDAO.getProduto(1);

		if(teste != null)
			System.out.println(teste.toString());
		
		ProdutoDAO.alterarProduto(teste, new BigDecimal("9.99"));
		
		teste = ProdutoDAO.getProduto(1);

		if(teste != null)
			System.out.println(teste.toString());
		
		PromocaoDAO.inserirPromocao(1, "LeveXPagueY", 5, new BigDecimal(3));
		
		teste.setPromocoes(PromocaoDAO.getPromocoes(teste));
		
		if(teste != null)
			System.out.println(teste.toString());
	}
}
