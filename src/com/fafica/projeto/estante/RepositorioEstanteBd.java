package com.fafica.projeto.estante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import com.fafica.projeto.conexao.ConexaoBd;

	public class RepositorioEstanteBd implements IRepositorioEstante {
		Connection conn;

		public RepositorioEstanteBd() throws ClassNotFoundException {
			this.conn = ConexaoBd.conexaoBd();
		}

		@Override
		public void cadastrar(Estante estante){
			
			// Criando a String SQL
			String sql = "insert into estante (codigo, rua) values (?,?)";

			
			try {
				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);
				// Atualizando o primeiro parametro
				preStatement.setInt(1, estante.getCodigo());
				preStatement.setString(2, estante.getRua());
			

				preStatement.execute();
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void atualizar(Estante estante){

			// Criando a String SQL
			String sql = "update estante set codigo= ? ,rua= ? where codigo = ?";
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;

			try {
				preStatement = conn.prepareStatement(sql);
				preStatement.setInt(1, estante.getCodigo());
				preStatement.setString(2, estante.getRua());
				preStatement.setInt(3, estante.getCodigo());
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
			String sql = "delete from estante where codigo = ?";
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
		public Estante procurar(int codigo){

			String sql = "select * from estante where codigo= ?";

			
			try {
				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setInt(1, codigo);
				ResultSet resultSet = preStatement.executeQuery();
				while (resultSet.next()) {
				int codigo2 = resultSet.getInt(1);
				String rua = resultSet.getString(2);
				
				Estante estante = new Estante(codigo2,rua);
				return estante;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public boolean existe(int codigo){
			
			String sql = "select * from estante where codigo= ?";

			
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
		public ArrayList<Estante> listar(){

			ArrayList<Estante> arrayListEstante = new ArrayList<Estante>();

			// Criando a String SQL
			String sql = "select * from estante";

			
			try {
				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);
				ResultSet resultSet = preStatement.executeQuery();

				// Verifica se retornou dados na consulta
				while (resultSet.next()) {
					// Pegando as colunas do registro
					int codigo2 = resultSet.getInt(1);
					String rua = resultSet.getString(2);
					Estante estante = new Estante(codigo2,rua);
					arrayListEstante.add(estante);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return arrayListEstante;
		}
	}