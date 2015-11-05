package com.fafica.projeto.cliente;

import java.util.ArrayList;
import com.fafica.projeto.cliente.IRepositorioCliente;
import com.fafica.projeto.cliente.RepositorioClienteArray;

	public class ControladorCliente implements IRepositorioCliente {

		private IRepositorioCliente RepositorioCliente;
		
		public ControladorCliente() {
			this.RepositorioCliente = new RepositorioClienteArray();
		}
		
		@Override
		public void cadastrar(Cliente cliente) {
			// TODO Auto-generated method stub
			this.RepositorioCliente.cadastrar(cliente);
		}

		@Override
		public void atualizar(Cliente cliente) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean remover(Integer codigo) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Cliente procurar(Integer codigo) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existe(Integer codigo) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Cliente> listar() {
			// TODO Auto-generated method stub
			return null;
		}

		
		
}

