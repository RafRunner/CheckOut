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

	private static final String SELECT_PRODUTO = "SELECT NOME, VALOR_UNITARIO FROM produtos WHERE IDENTIFICADOR = ?";
	
	private static final String GET_PRODUTOS = "SELECT NOME, VALOR_UNITARIO, IDENTIFICADOR FROM produtos";
	
	private static final String INSERT_PRODUTO = "INSERT INTO produtos (NOME, VALOR_UNITARIO, IDENTIFICADOR)"
			+ "VALUES (?, ?, ?)";
	
	private static final String UPDATE_PRODUTO = "UPDATE produtos SET VALOR_UNITARIO = ? WHERE IDENTIFICADOR = ?";
	
	private static final String DELETE_PRODUTO = "DELETE FROM produtos WHERE IDENTIFICADOR = ?";
	
	public static Produto getProduto(int identificador)
	{
		Produto produto = null;
		
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement consulta = conexao.prepareStatement(SELECT_PRODUTO)){
			
			consulta.setInt(1, identificador);
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				String nome = resultado.getString("NOME");
				BigDecimal valorUnitario = resultado.getBigDecimal("VALOR_UNITARIO");
				
				produto = new Produto(identificador, nome, valorUnitario, new ArrayList<Promocao>());
				ArrayList<Promocao> promocoes = PromocaoDAO.getPromocoes(produto);
				produto.setPromocoes(promocoes);
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
	
	public static ArrayList<Produto> getProdutos()
	{
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement consulta = conexao.prepareStatement(GET_PRODUTOS)){
			
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				String nome = resultado.getString("NOME");
				BigDecimal valorUnitario = resultado.getBigDecimal("VALOR_UNITARIO");
				int identificador = resultado.getInt("IDENTIFICADOR");
				
				Produto produto = new Produto(identificador, nome, valorUnitario, new ArrayList<Promocao>());
				ArrayList<Promocao> promocoes = PromocaoDAO.getPromocoes(produto);
				produto.setPromocoes(promocoes);
				produtos.add(produto);
			}
			else {
				System.out.println("Produto não encontrado!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public static void inserirProduto(Produto produto)
	{		
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement insercao = conexao.prepareStatement(INSERT_PRODUTO)){
			
			insercao.setString(1, produto.getNome());
			insercao.setBigDecimal(2, produto.getValor());
			insercao.setInt(3, produto.getId());
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
			alteracao.setInt(2, produto.getId());
			alteracao.execute();
		}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static void removerProduto(Produto produto)
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement remocao = conexao.prepareStatement(DELETE_PRODUTO)){
			
			remocao.setInt(1, produto.getId());
			remocao.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
