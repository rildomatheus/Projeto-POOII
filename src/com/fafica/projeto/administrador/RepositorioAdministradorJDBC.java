package com.fafica.projeto.administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioAdministradorJDBC implements IRepositorioAdministrador {

	
	public void cadastrar(Connection con, Administrador administrador) throws AdministradorJaCadastradoException{
		String sql = "insert into administrador values(?,?)";
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setInt(1, administrador.getCodigo());
			stm.setString(2, administrador.getNome());
			stm.executeUpdate();
		} catch(SQLException e){
			e.getMessage();
		}
	}


	public void atualizar(Connection con, Administrador administrador) throws AdministradorNaoEncontradoException {
		String sql = "update administrador set codigo=?, nome=?";
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setInt(1, administrador.getCodigo());
			stm.setString(2, administrador.getNome());
			stm.executeUpdate();
		
		} catch(SQLException e){
			e.getMessage();
		}
	}

	
	public void remover(Connection con, Administrador administrador) throws AdministradorNaoEncontradoException{
		String sql = "delete administrador where codigo=?";
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setInt(1, administrador.getCodigo());
			stm.executeUpdate();
		} catch(SQLException e){
			e.getMessage();
		}
	}


	public Administrador procurar(int codigo) throws AdministradorNaoEncontradoException {

		return null;
	}


	public boolean existe(int codigo) {
		
		return false;
	}


	public ArrayList<Administrador> listar(Connection con){
		ArrayList<Administrador> listar = new ArrayList<>();
		String sql = "select into codigo, numero from administrador";
		try(PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()){
				while(rs.next()){
					listar.add(new Administrador(rs.getInt(1), rs.getString(2)));
				}
			
		} catch(SQLException e){
			e.getMessage();
		}
		return listar;
	}


	


	



}
