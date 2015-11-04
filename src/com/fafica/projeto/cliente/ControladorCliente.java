package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public class ControladorCliente implements IRepositorioCliente {

		@Override
		public void cadastrar(Cliente cliente) {
			// TODO Auto-generated method stub
			System.out.println(cliente);
			
		}

		@Override
		public void atualizar(Cliente cliente) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean remover(int codigo) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Cliente procurar(int codigo) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existe(int codigo) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Cliente> listar() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	
}

