package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import backEnd.Produto;
import backEnd.Promocao;

public class ProdutoDAO {

	private static final String SELECT_PRODUTO = "SELECT id, VALOR_UNITARRIO FROM produtos WHERE NOME = ?";
	
	private static final String INSERT_PRODUTO = "INSERT INTO produtos (NOME, VALOR_UNITARIO)"
			+ "VALUES (?, ?)";
	
	private static final String UPDATE_PRODUTO = "UPDATE produtos SET VALOR_UNITARIO = ? WHERE NOME = ?";
	
	private static final String DELET_PRODUTO = "DELET FROM produtos WHERE NOME = ?";
	
	public static Produto getProduto(String nome) 
	{
		Produto produto = null;
		
		try(Connection conexao = FabricaConexao.getConection();
			PreparedStatement consulta = conexao.prepareStatement(SELECT_PRODUTO)){
			
			consulta.setString(1, nome);
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				int id = Integer.parseInt(resultado.getString("id"));
				double valorUnitario = Double.parseDouble(resultado.getString("VALOR_UNITARIO"));
				
				produto = new Produto(id, nome, valorUnitario, new ArrayList<Promocao>());
			}
			else {
				System.out.println("Produto não encontrado!");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return produto;
	}
}
