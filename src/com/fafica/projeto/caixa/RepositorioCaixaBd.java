package com.fafica.projeto.caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.conexao.ConexaoBd;
import com.fafica.projeto.estante.Estante;
	
	public class RepositorioCaixaBd implements IRepositorioCaixa {
		Connection conn;

		public RepositorioCaixaBd() throws ClassNotFoundException {
			this.conn = ConexaoBd.conexaoBd();
		}

		@Override
		public void cadastrar(Caixa caixa){
			
			// Criando a String SQL
			String sql = "insert into caixa (codigo, descricao, cliente, endereco) values (?,?,?,?)";

			
			try {
				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);
				// Atualizando o primeiro parametro
				preStatement.setInt(1, caixa.getCodigo());
				preStatement.setString(2, caixa.getDescricao());
				preStatement.setObject(3, caixa.getCliente());
				preStatement.setObject(4, caixa.getEstante());
				preStatement.execute();
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

		@Override
		public void atualizar(Caixa caixa){

			// Criando a String SQL
			String sql = "update caixa set codigo= ? ,descricao= ?, cliente= ?, estante= ? where codigo = ?";
			// Criar o PreparedStatement, objeto para executar a query
			

			try {
				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setInt(1, caixa.getCodigo());
				preStatement.setString(2, caixa.getDescricao());
				preStatement.setObject(3, caixa.getCliente());
				preStatement.setObject(4, caixa.getEstante());

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
			String sql = "delete from caixa where codigo = ?";

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
		public Caixa procurar(int codigo){

			String sql = "select * from caixa where codigo= ?";

			
			try {
				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setInt(1, codigo);
				ResultSet resultSet = preStatement.executeQuery();
				while (resultSet.next()) {
				int codigo2 = resultSet.getInt(2);
				String descricao = resultSet.getString(3);
				Cliente cliente = (Cliente) resultSet.getObject(4);
				Estante estante = (Estante) resultSet.getObject(5);
				
				Caixa caixa = new Caixa(codigo2,descricao,cliente,estante);
				return caixa;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public boolean existe(int codigo){
			
			String sql = "select * from caixa where codigo= ?";

			
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
		public ArrayList<Caixa> listar(){

			ArrayList<Caixa> arrayListCaixa = new ArrayList<Caixa>();

			// Criando a String SQL
			String sql = "select * from caixa";

			// Criar o PreparedStatement, objeto para executar a query
			
			try {
				PreparedStatement preStatement = conn.prepareStatement(sql);

				ResultSet resultSet = preStatement.executeQuery();

				// Verifica se retornou dados na consulta
				while (resultSet.next()) {
					// Pegando as colunas do registro
					int codigo2 = resultSet.getInt(1);
					String descricao = resultSet.getString(2);
					Cliente cliente = (Cliente) resultSet.getObject(3);
					Estante estante = (Estante) resultSet.getObject(4);
					
				
					Caixa caixa = new Caixa(codigo2,descricao,cliente,estante);
					arrayListCaixa.add(caixa);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return arrayListCaixa;
		}
	}

