package com.fafica.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBd {
	public static Connection conexaoBd() throws ClassNotFoundException{
	       
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoPooII","postgres","soseiquenadasei");
            System.out.println("Conectado com Sucesso");
            return con;
        }
            
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, erro);
            
            return null;
        }    
        
    
}
}

