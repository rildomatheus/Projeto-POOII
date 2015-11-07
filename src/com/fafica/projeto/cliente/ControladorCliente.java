package com.fafica.projeto.cliente;

import java.util.ArrayList;


import com.fafica.projeto.cliente.IRepositorioCliente;
import com.fafica.projeto.cliente.RepositorioClienteArrayList;

	public class ControladorCliente{

		private IRepositorioCliente repositorioCliente;
		
		public ControladorCliente() {
			this.repositorioCliente = new RepositorioClienteArrayList();
		}
		
		
		public void cadastrar(Cliente cliente) throws ClienteInvalidoException, CampoObrigatorioInvalidoException{
			
			if (cliente == null) throw new ClienteInvalidoException("Cliente Inválido.");
		    if (cliente.getNome().equals("")) throw new CampoObrigatorioInvalidoException("Nome");
		      
		//    this.repositorioCliente.cadastrar(cliente);
			
		}

		
		public void atualizar(Cliente cliente) {
			
			
		}

		
		public boolean remover(Integer codigo) {
			
			return false;
		}

		
		public Cliente procurar(Integer codigo) {
			
			return null;
		}

		
		public boolean existe(Integer codigo) {
			
			return false;
		}

		
		public ArrayList<Cliente> listar() {
			
			return null;
		}

		
		
}

