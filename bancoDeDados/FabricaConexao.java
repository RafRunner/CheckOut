package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static final String URL = "http://127.0.0.1:49407/browser/";
	private static final String USER = "postgres";
	private static final String SENHA = "zg@123";
	
	public static Connection getConection() throws SQLException
	{
		try {
			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(URL, USER, SENHA);
		}
		catch (ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}
}
