package bancoDeDados;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.LeveXPagueY;
import dominio.PagueXPorY;
import dominio.Produto;
import dominio.Promocao;

public class PromocaoDAO {

	private static final String SELECT_PROMOCOES = "SELECT TIPO, QUANTIDADE_ATIVACAO, VALOR_DESCONTO "
			+ "FROM promocoes WHERE FK_PRODUTO = ?";
	
	private static final String INSERT_PROMOCAO = "INSERT INTO promocoes "
			+ "(TIPO, QUANTIDADE_ATIVACAO, VALOR_DESCONTO, FK_PRODUTO)"
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String UPDATE_PROMOCAO = "UPDATE promocoes SET VALOR_DESCONTO = ? "
			+ "WHERE TIPO = ? and QUANTIDADE_ATIVACAO = ? and FK_PRODUTO = ?";
	
	private static final String DELETE_PROMOCAO = "DELETE FROM promocoes "
			+ "WHERE TIPO = ? and QUANTIDADE_ATIVACAO = ? and FK_PRODUTO = ?";
	
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
				
				if(tipo.equals(LeveXPagueY.class.getSimpleName())) {
					promocoes.add(new LeveXPagueY(produto.getValor(), quantidadeAtivacao, valorDesconto.intValue()));
				}
				else if (tipo.equals(PagueXPorY.class.getSimpleName())) {
					promocoes.add(new PagueXPorY(produto.getValor(), valorDesconto, quantidadeAtivacao));
				}
			}
		}
		catch(Exception e) {
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
		catch(SQLException e1) {
			System.out.println("Essa promoção já existe no Banco de dados! (tipo = " + tipo + ", quantidade ativação = " + quantidadeAtivacao + ", valor desconto = " + valorDesconto + ", id do produto = " + idProduto 
					+ ")\nPara atualizar seus detalhes, use:\n"
					+ "PromocaoDAO.alterarPromocao(int idProduto, String tipo, int quantidadeAtivacao, BigDecimal novoDesconto)\n");
		}
		catch(Exception e) {
			e.printStackTrace();
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
			catch(Exception e) {
				e.printStackTrace();
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
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}
