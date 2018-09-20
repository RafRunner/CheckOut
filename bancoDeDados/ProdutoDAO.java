package bancoDeDados;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backEnd.Produto;
import backEnd.Promocao;

public class ProdutoDAO {

	private static final String SELECT_PRODUTO = "SELECT id, VALOR_UNITARIO FROM produtos WHERE NOME = ?";
	
	private static final String INSERT_PRODUTO = "INSERT INTO produtos (NOME, VALOR_UNITARIO)"
			+ "VALUES (?, ?)";
	
	private static final String UPDATE_PRODUTO = "UPDATE produtos SET VALOR_UNITARIO = ? WHERE NOME = ?";
	
	private static final String DELETE_PRODUTO = "DELETE FROM produtos WHERE NOME = ?";
	
	public static Produto getProduto(String nome) throws SQLException 
	{
		Produto produto = null;
		
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement consulta = conexao.prepareStatement(SELECT_PRODUTO)){
			
			consulta.setString(1, nome);
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				int id = resultado.getInt("id");
				BigDecimal valorUnitario = resultado.getBigDecimal("VALOR_UNITARIO");	
				
				produto = new Produto(id, nome, valorUnitario, new ArrayList<Promocao>());
			}
			else {
				System.out.println("Produto não encontrado!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	public static void inserirProduto(Produto produto)
	{		
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement insercao = conexao.prepareStatement(INSERT_PRODUTO)){
			
			insercao.setString(1, produto.getNome());
			insercao.setBigDecimal(2, produto.getValor());
			insercao.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void alterarProduto(Produto produto, BigDecimal novoValor)
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement alteracao = conexao.prepareStatement(UPDATE_PRODUTO)){
			
			alteracao.setBigDecimal(1, novoValor);
			alteracao.setString(2, produto.getNome());
			alteracao.execute();
		}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static void removerProduto(Produto produto)
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement deletar = conexao.prepareStatement(DELETE_PRODUTO)){
			
			deletar.setString(1, produto.getNome());
			deletar.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
