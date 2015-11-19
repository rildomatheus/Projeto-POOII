package com.fafica.projeto.administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoAdministrador {
	
	public static void main(String []args) throws SQLException{
		Connection conn = DriverManager
		.getConnection("jdbc:oracle:thin:@192.168.43.59:1521:XE:LocationFile", "system", "root");
		
		 String sql ="insert into administrador (codigo, nome) values (?, ?)";
		 
		 PreparedStatement pst = conn.prepareStatement(sql, new String[]{"CODIGO_ADMINISTRADOR"});
		 pst.setString(1231, "Joazinho trinta");
		 pst.execute();
		 
		 ResultSet resultSet = pst.getGeneratedKeys();
		 Integer codigoAdministrador = 0;
		 
		 while(resultSet.next()) {
	        	codigoAdministrador = resultSet.getInt(1);
	        }
	        System.out.println("ID do Insert no Banco " + codigoAdministrador);
	        
	        // Fechando conexões
	        conn.close();
	        pst.close();
	        resultSet.close();
		
		
	}

}