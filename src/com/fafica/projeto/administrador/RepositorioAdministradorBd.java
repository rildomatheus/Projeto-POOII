package com.fafica.projeto.administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.conexao.ConexaoBd;
import com.fafica.projeto.funcionario.Funcionario;

public class RepositorioAdministradorBd implements IRepositorioAdministrador{
	Connection conn;
	
	public RepositorioAdministradorBd() throws ClassNotFoundException {
		this.conn = ConexaoBd.conexaoBd();
	}
	
	public void cadastrar(Administrador administrador){
		
		// Criando a String SQL
		String sql = "insert into administrador (codigo,nome) values (?,?)";

		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			// Atualizando o primeiro parametro
			preStatement.setInt(1, administrador.getCodigo());
			preStatement.setString(2, administrador.getNome());

			preStatement.execute();
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Administrador administrador){

		// Criando a String SQL
		String sql = "update administrador set codigo= ? ,nome= ? where codigo = ?";
		

		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			preStatement.setInt(1, administrador.getCodigo());
			preStatement.setString(2, administrador.getNome());
		    preStatement.setInt(3, administrador.getCodigo());

			// Executando o select
			preStatement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(int codigo){

		// Criando a String SQL
		String sql = "delete from administrador where codigo = ?";

		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			
			preStatement.setInt(1, codigo);

			// Executando o select
			preStatement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Administrador procurar(int codigo){

		String sql = "select * from administrador where codigo= ?";

		
		try {
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, codigo);
			ResultSet resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
			int codigo2 = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			
			Administrador administrador = new Administrador(codigo2,nome);
			return administrador;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}

	@Override
	public boolean existe(int codigo){
		
		String sql = "select * from administrador where codigo= ?";

		PreparedStatement preStatement;
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, codigo);
			ResultSet resultSet = preStatement.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<Administrador> listar(){

		ArrayList<Administrador> arrayListAdministrador = new ArrayList<Administrador>();

		// Criando a String SQL
		String sql = "select * from administrador";

		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				// Pegando as colunas do registro
				int codigo2 = resultSet.getInt(1);
				String nome = resultSet.getString(2);

			
				Administrador administrador = new Administrador(codigo2,nome);
				arrayListAdministrador.add(administrador);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListAdministrador;
	}
}