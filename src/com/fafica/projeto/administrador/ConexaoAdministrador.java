package com.fafica.projeto.administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexaoAdministrador{

//Cria a conexão com o banco de dados MySql usando o JDBC
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE:LocationFile","system","system");

/*
 * Exemplo de Consultar
 */
// Criando a String SQL
	
		//String sql ="select * from adminstrador";

		//PreparedStatement preStatement = conn.prepareStatement(sql);

//preStatement.setInt(1, 2);
// Executando o select
		//ResultSet resultSet = preStatement.executeQuery();

/*
 * Exemplo de Select
 */

		//ArrayList<Administrador> listar = new ArrayList<Administrador>();


	//while(resultSet.next()){
		
	//Pegando as colunas do registro
	
	//System.out.print(resultSet.getString("codigo") 	+ "\t");
	//System.out.print(resultSet.getString("nome") 	+ "\t");
	//System.out.println();
	//Administrador administrador = new Administrador(resultSet.getInt("codigo"), resultSet.getString("nome"));
	//listar.add(administrador);


















		
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
	       //conn.close();
	       //pst.close();
	        //resultSet.close();
		
		
	

