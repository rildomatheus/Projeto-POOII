package com.fafica.projeto.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.conexao.ConexaoBd;

public class RepositorioClienteBd implements IRepositorioCliente {
	Connection conn;

	public RepositorioClienteBd(){
		try {
			this.conn = ConexaoBd.conexaoBd();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cadastrar(Cliente cliente){
		
		// Criando a String SQL
		String sql = "insert into cliente (codigo,nome,loja) values (?,?,?)";

		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			// Atualizando o primeiro parametro
			preStatement.setInt(1, cliente.getCodigo());
			preStatement.setString(2, cliente.getNome());
			preStatement.setInt(3, cliente.getLoja());
			preStatement.execute();
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void atualizar(Cliente cliente){

		// Criando a String SQL
		String sql = "update cliente set codigo= ? ,nome= ?, loja= ? where codigo = ?";
		

		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			
			preStatement.setInt(1, cliente.getCodigo());
			preStatement.setString(2, cliente.getNome());
			preStatement.setInt(3, cliente.getLoja());
		    preStatement.setInt(4, cliente.getCodigo());

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
		String sql = "delete from cliente where codigo = ?";

		// Criar o PreparedStatement, objeto para executar a query
		
		try {
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
	public Cliente procurar(int codigo){

		String sql = "select * from cliente where codigo= ?";

		
		try {
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, codigo);
			ResultSet resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
			int codigo2 = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			int loja = resultSet.getInt(3);
			
			Cliente cliente = new Cliente(codigo2,nome,loja);
			return cliente;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public boolean existe(int codigo){
		
		String sql = "select * from cliente where codigo= ?";

		
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
	public ArrayList<Cliente> listar(){

		ArrayList<Cliente> arrayListCliente = new ArrayList<Cliente>();

		// Criando a String SQL
		String sql = "select * from cliente";

		
		try {
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				// Pegando as colunas do registro
				int codigo2 = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				int loja = resultSet.getInt(3);
			
				Cliente cliente = new Cliente(codigo2,nome,loja);
				arrayListCliente.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return arrayListCliente;
	}
}