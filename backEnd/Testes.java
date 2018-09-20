package backEnd;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import bancoDeDados.ProdutoDAO;

public class Testes {

	public static void main(String[] args) throws SQLException
	{
		ProdutoDAO.removerProduto(new Produto("A", new BigDecimal("10.50"), new ArrayList<Promocao>()));
		
		Produto teste = null;

		teste = ProdutoDAO.getProduto("Sabao");

		if(teste != null)
			System.out.println(teste.toString());
	}
}
