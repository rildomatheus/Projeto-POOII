package com.fafica.projeto.administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;

public class TelaTesteAdministrador {
	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try(Connection con = DriverManager.getConnection(url, "admin", "admin1")){
			//RepositorioAdministradorJDBC jdbc = new RepositorioAdministrador();
			
			Administrador administrador = new Administrador(1212,"Joao Peba");
			Administrador administrador2 = new Administrador(121,"Joao Pebinha");
			
		}
		
		Fachada fachada = Fachada.getInstance();
		
	    //fachada.cadastrarAdministrador(adm);
		//fachada.cadastrarAdministrador(adm1);
		//fachada.cadastrarAdministrador(adm2);
		//fachada.atualizarAdministrador(adm2);
		///fachada.removerAdministrador(3458);
		//System.out.println(fachada.listarAdministrador());
		
		try {
			fachada.cadastrarAdministrador(adm);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (AdministradorJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e){
			System.out.println("ERROR!");
		}
		
		try {
			fachada.atualizarAdministrador(adm);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());;
		} catch (AdministradorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		}catch (Exception e){
			System.out.println("ERROR Critical!!");
		}
		
		try {
			fachada.removerAdministrador(12);
		} catch (AdministradorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		}catch (Exception e){
			System.out.println("ERROR Desconhecido!!");
		}
		
		try {
			fachada.procurarAdministrador(12);
		} catch (AdministradorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		}catch (Exception e){
			System.out.println("ERROR");
		}
		
		System.out.println(fachada.listarAdministrador());
	}

	    
	    
}
