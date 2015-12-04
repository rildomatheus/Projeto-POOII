package com.fafica.projeto.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.conexao.ConexaoBd;

public class RepositorioFuncionarioBd implements IRepositorioFuncionario{
	Connection conn;
	
	public RepositorioFuncionarioBd(){
		try {
			this.conn = ConexaoBd.conexaoBd();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrar(Funcionario funcionario){
		
		// Criando a String SQL
		String sql = "insert into funcionario (codigo,nome) values (?,?)";

		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			// Atualizando o primeiro parametro
			preStatement.setInt(1, funcionario.getCodigo());
			preStatement.setString(2, funcionario.getNome());
			preStatement.execute();
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void atualizar(Funcionario funcionario){

		// Criando a String SQL
		String sql = "update funcionario set codigo= ? ,nome= ? where codigo = ?";
		
		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, funcionario.getCodigo());
			preStatement.setString(2, funcionario.getNome());
			preStatement.setInt(3, funcionario.getCodigo());
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
		String sql = "delete from funcionario where codigo = ?";

		
		
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
	public Funcionario procurar(int codigo){

		String sql = "select * from funcionario where codigo= ?";


		try {
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, codigo);
			ResultSet resultSet = preStatement.executeQuery();
			
			while (resultSet.next()) {
				int codigo2 = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				Funcionario funcionario = new Funcionario(codigo2,nome);
				return funcionario;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public boolean existe(int codigo){
		
		String sql = "select * from funcionario where codigo= ?";

		
		try {
			PreparedStatement preStatement = conn.prepareStatement(sql);
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
	public ArrayList<Funcionario> listar(){

		ArrayList<Funcionario> arrayListFuncionario = new ArrayList<Funcionario>();

		// Criando a String SQL
		String sql = "select * from funcionario";

		
		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();
			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				// Pegando as colunas do registro
				int codigo = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				Funcionario funcionario = new Funcionario(codigo,nome);
				arrayListFuncionario.add(funcionario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListFuncionario;
	}
}