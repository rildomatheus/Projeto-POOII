package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoBanco {

	public static void main(String[] args) throws SQLException {
		String sql = "select CODIGO, NOME from ADMINISTRADOR";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//Class.forName("oracle.jdbc.OracleDriver");
		
		try( Connection con =
				DriverManager.getConnection(url,"admin","admin1");
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery()) {
			
			while(rs.next()){
				String result = rs.getString("CODIGO")
						+ ";" + rs.getString("NOME");
							
				System.out.println(result);
			}
		}

	}

}
