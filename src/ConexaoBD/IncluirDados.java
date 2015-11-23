package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncluirDados {

	public static void main(String[] args) throws SQLException {
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "insert into ADMINISTRADOR values (?,?)";
	   
		//fazer um array no metodo cadastrar com esse for
		String[] administrador = {"Joao da silva","Maria Pera aqui","Pedro da Pipoca doce"};
    	try( Connection con = DriverManager.getConnection(url,"admin","admin1")){
    	
    			try(PreparedStatement stm = con.prepareStatement(sql)){
    		for (int i = 0; i < administrador.length; i++) {
    			stm.setInt(1, i);
    			stm.setString(2, administrador[i]);
    			stm.addBatch();
				
			}stm.executeBatch();
			//fazendo um select
    	}catch (SQLException e){}

    			sql = "select nome, codigo from ADMINISTRADOR";
    			try(PreparedStatement stm2 = con.prepareStatement(sql);
    			ResultSet rs = stm2.executeQuery()){
    				while(rs.next()){
    					System.out.println(rs.getString(1) + ":" + rs.getString(2));
    				}
    				
    			}
	}
   }
  }

