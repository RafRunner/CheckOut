package bancoDeDados;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backEnd.LeveXPagueY;
import backEnd.PagueXPorY;
import backEnd.Produto;
import backEnd.Promocao;

public class PromocaoDAO {

	private static final String SELECT_PROMOCOES = "SELECT TIPO, QUANTIDADE_ATIVACAO, VALOR_DESCONTO"
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
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement consulta = conexao.prepareStatement(SELECT_PROMOCOES)){
			
			consulta.setInt(1, produto.getId());
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				String tipo = resultado.getString("TIPO");
				int quantidadeAtivacao = resultado.getInt("QUANTIDADE_ATIVACAO");
				BigDecimal valorDesconto = resultado.getBigDecimal("VALOR_DESCONTO");
				int fkProduto = resultado.getInt("FKPRODUTO");
				
				if(tipo == "LeveXPagueY") {
					promocoes.add(new LeveXPagueY(produto.getValor(), quantidadeAtivacao, valorDesconto.intValue()));
				}
				else {
					promocoes.add(new PagueXPorY(produto.getValor(), valorDesconto, quantidadeAtivacao));
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return promocoes;
	}
	
	public static void inserirPromocao(Produto produto, String tipo, int quantidadeAtivacao, BigDecimal valorDesconto)
	{
		
	}
}
