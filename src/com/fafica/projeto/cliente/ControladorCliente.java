package com.fafica.projeto.cliente;

import java.util.ArrayList;


import com.fafica.projeto.cliente.IRepositorioCliente;
import com.fafica.projeto.cliente.RepositorioClienteArrayList;

	public class ControladorCliente{

		private IRepositorioCliente repositorioCliente;
		
		public ControladorCliente() {
			this.repositorioCliente = new RepositorioClienteArrayList();
		}
		
		
		public void cadastrar(Cliente cliente)throws ClienteJaCadastradoException{
		    
		    this.repositorioCliente.cadastrar(cliente);
			
		}

		
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException  {
			
			
			this.repositorioCliente.atualizar(cliente);
			
		}

		
		public boolean remover(Integer codigo) throws ClienteNaoEncontradoException{
			
			return repositorioCliente.existe(codigo);		}

		
		public Cliente procurar(Integer codigo) throws ClienteNaoEncontradoException{
			
			return repositorioCliente.procurar(codigo);
		}

		
		public boolean existe(Integer codigo) {
			
			return repositorioCliente.existe(codigo);
		}

		
		public ArrayList<Cliente> listar() {
			
			return repositorioCliente.listar();
			
		}

		
		
}

