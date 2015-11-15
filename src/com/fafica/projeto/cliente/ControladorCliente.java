package com.fafica.projeto.cliente;

import java.util.ArrayList;


import com.fafica.projeto.cliente.IRepositorioCliente;
import com.fafica.projeto.cliente.RepositorioClienteArrayList;

	public class ControladorCliente{

		private IRepositorioCliente repositorioCliente;
		
		public ControladorCliente() {
			this.repositorioCliente = new RepositorioClienteArrayList();
		}
		
		
		public void cadastrar(Cliente cliente)throws ClienteJaCadastradoException, CampoObritarorioInvalidoException{
			if (cliente.getNome() == null) throw new CampoObritarorioInvalidoException(" Nome ");
			if (cliente.getNome() == " ") throw new CampoObritarorioInvalidoException(" Nome ");
		    this.repositorioCliente.cadastrar(cliente);
			
		}

		
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException  {
			
			
			this.repositorioCliente.atualizar(cliente);
			
		}

		
		public void remover(int codigo) throws ClienteNaoEncontradoException{
			
			this.repositorioCliente.existe(codigo);		
		}

		
		public Cliente procurar(int codigo) throws ClienteNaoEncontradoException{
			
			return repositorioCliente.procurar(codigo);
		}

		
		public boolean existe(int codigo) {
			
			return repositorioCliente.existe(codigo);
		}

		
		public ArrayList<Cliente> listar() {
			
			return repositorioCliente.listar();
			
		}	
}

