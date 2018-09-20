package bancoDeDados;

import java.util.ArrayList;

import backEnd.Produto;
import backEnd.Promocao;

public class PromocaoDAO {

	private static final String SELECT_PROMOCAO = "SELECT TIPO, QUANTIDADE_ATIVACAO, VALOR_DESCONTO"
			+ "FROM promocoes WHERE FKPRODUTO = ?";
	
	private static final String INSERT_PROMOCAO = "INSERT INTO promocoes "
			+ "(TIPO, QUANTIDADE_ATIVACAO, VALOR_DESCONTO, FKPRODUTO)"
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String UPDATE_PROMOCAO = "UPDATE promocoes SET VALOR_DESCONTO = ? "
			+ "WHERE TIPO = ?, QUANTIDADE_ATIVACAO = ?, FKPRODUTO = ?";
	
	private static final String DELET_PROMOCAO = "DELET FROM promocoes "
			+ "WHERE TIPO = ?, QUANTIDADE_ATIVACAO = ?, FKPRODUTO = ?";
	
	public static ArrayList<Promocao> getPromocoes(Produto produto)
	{
		return null;
	}
}
