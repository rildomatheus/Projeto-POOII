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

		public RepositorioCaixaBd(){
			try {
				this.conn = ConexaoBd.conexaoBd();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void cadastrar(Caixa caixa){
			
			// Criando a String SQL
			String sql = "insert into caixa (codigo, descricao, codigo_cliente, nome_cliente, loja_cliente, codigo_estante, rua_estante ) values (?,?,?,?,?,?,?)";

		
			try {
				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);
				// Atualizando o primeiro parametro
				preStatement.setInt(1, caixa.getCodigo());
				preStatement.setString(2, caixa.getDescricao());
				preStatement.setInt(3, caixa.getCliente().getCodigo());
				preStatement.setString(4, caixa.getCliente().getNome());
				preStatement.setInt(5, caixa.getCliente().getLoja());
				preStatement.setInt(6, caixa.getEstante().getCodigo());
				preStatement.setString(7, caixa.getEstante().getRua());
				
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
			String sql = "update caixa set descricao= ?, codigo_cliente= ?, nome_cliente=?, loja_cliente= ?, codigo_estante= ?, rua_estante= ? where codigo = ?";
			// Criar o PreparedStatement, objeto para executar a query
			

			try {
				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, caixa.getDescricao());
				preStatement.setInt(2, caixa.getCliente().getCodigo());
				preStatement.setString(3, caixa.getCliente().getNome());
				preStatement.setInt(4, caixa.getCliente().getLoja());
				preStatement.setInt(5, caixa.getEstante().getCodigo());
				preStatement.setString(6, caixa.getEstante().getRua());
				preStatement.setInt(7, caixa.getCodigo());
				
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
					Cliente cliente = new Cliente (resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
					Estante estante = new Estante(resultSet.getInt(6),resultSet.getString(7));
					Caixa caixa = new Caixa(resultSet.getInt(1),resultSet.getString(2),cliente,estante);
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
					Cliente cliente = new Cliente (resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
					Estante estante = new Estante(resultSet.getInt(6),resultSet.getString(7));
					Caixa caixa = new Caixa(resultSet.getInt(1),resultSet.getString(2),cliente,estante);
					arrayListCaixa.add(caixa);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return arrayListCaixa;
		}
	}

