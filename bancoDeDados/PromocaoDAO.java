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
			+ "FROM promocoes WHERE FK_PRODUTO = ?";
	
	private static final String INSERT_PROMOCAO = "INSERT INTO promocoes "
			+ "(TIPO, QUANTIDADE_ATIVACAO, VALOR_DESCONTO, FK_PRODUTO)"
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String UPDATE_PROMOCAO = "UPDATE promocoes SET VALOR_DESCONTO = ? "
			+ "WHERE TIPO = ?, QUANTIDADE_ATIVACAO = ?, FK_PRODUTO = ?";
	
	private static final String DELETE_PROMOCAO = "DELET FROM promocoes "
			+ "WHERE TIPO = ?, QUANTIDADE_ATIVACAO = ?, FK_PRODUTO = ?";
	
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
	
	public static void inserirPromocao(int idProduto, String tipo, int quantidadeAtivacao, BigDecimal valorDesconto)
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement insercao = conexao.prepareStatement(INSERT_PROMOCAO)){
				
				insercao.setString(1, tipo);
				insercao.setInt(2, quantidadeAtivacao);
				insercao.setBigDecimal(3, valorDesconto);
				insercao.setInt(4, idProduto);
				insercao.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static void alterarPromocao(int idProduto, String tipo, int quantidadeAtivacao, BigDecimal novoDesconto)
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement alterecao = conexao.prepareStatement(UPDATE_PROMOCAO)){
					
				alterecao.setBigDecimal(1, novoDesconto);
				alterecao.setString(2, tipo);
				alterecao.setInt(3, quantidadeAtivacao);
				alterecao.setInt(4, idProduto);
				alterecao.execute();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static void removerPromocao(int idProduto, String tipo, int quantidadeAtivacao)
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement remocao = conexao.prepareStatement(DELETE_PROMOCAO)){
						
				remocao.setString(1, tipo);
				remocao.setInt(2, quantidadeAtivacao);
				remocao.setInt(3, idProduto);
				remocao.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
}
