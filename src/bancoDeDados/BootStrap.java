package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Produto;
import dominio.Promocao;
import leitorDeDados.FabricaObjetos;

public class BootStrap {

	private static final String CRIAR_TABELAS_SQL = 
			"CREATE TABLE IF NOT EXISTS produtos(\r\n" + 
			"  id SERIAL PRIMARY KEY,\r\n" + 
			"  nome character varying(30) UNIQUE,\r\n" + 
			"  valor_unitario numeric,\r\n" + 
			"  identificador integer UNIQUE\r\n" + 
			"  );"
			+ ""
			+ "CREATE TABLE IF NOT EXISTS promocoes(\r\n" + 
			"  id SERIAL PRIMARY KEY,\r\n" + 
			"  tipo character varying(30),\r\n" + 
			"  quantidade_ativacao integer,\r\n" + 
			"  valor_desconto numeric,\r\n" + 
			"  fk_produto integer REFERENCES produtos (identificador),\r\n" + 
			"  UNIQUE (tipo, quantidade_ativacao, fk_produto)\r\n" + 
			");";
	
	public static void criarTabelas()
	{
		try (Connection conexao = FabricaConexao.getConection();
			PreparedStatement criacao = conexao.prepareStatement(CRIAR_TABELAS_SQL)){
		
			criacao.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void subirInformacao()
	{
		ArrayList<Produto> produtos = FabricaObjetos.criarProdutos();
		
		for(Produto produto : produtos)
		{
			ProdutoDAO.inserirProduto(produto);
			for(Promocao promocao : produto.getPromocoes()) 
			{
				PromocaoDAO.inserirPromocao(produto.getId(), promocao.getClass().getSimpleName(), promocao.getQuantidadeAtivacao(), promocao.getValorDesconto());
			}
		}
	}
	
	public static void carregarBanco()
	{
		criarTabelas();
		subirInformacao();
	}
}
