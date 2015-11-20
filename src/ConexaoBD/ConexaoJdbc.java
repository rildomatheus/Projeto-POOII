package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJdbc {
			
		public static Connection getConexao() throws Exception{
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE:LocationFile","system","system");
			String conexao = ("jdbc:oracle:thin:@localhost:1521:XE:LocationFile");
			String usuario = "system";
			String senha = "system";
			
			if(conn == null){
				Class.forName("oracle.jdbc.driver.OracleDriver");
					try {
					conn = DriverManager.getConnection(conexao,usuario,senha);
				} catch (SQLException e) {
					throw new Exception ("SQLException => ConnectionManager: " + e.getMessage());
				}
				
			}
			return conn;
		}
	}

