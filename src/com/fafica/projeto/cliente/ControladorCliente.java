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
		    repositorioCliente.cadastrar(cliente);
			
		}

		
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException  {
			
			if(!existe(cliente.getCodigo())) throw new ClienteNaoEncontradoException();
			repositorioCliente.atualizar(cliente);
			
		}

		
		public void remover(int codigo) throws ClienteNaoEncontradoException{
			if(codigo == codigo){
			 repositorioCliente.remover(codigo);
			}else{
			throw new ClienteNaoEncontradoException();
			}
		}
		
		public Cliente procurar(int codigo) throws ClienteNaoEncontradoException{
			if(codigo == codigo){
			return repositorioCliente.procurar(codigo);
			}else{
				throw new ClienteNaoEncontradoException();
			}
		}

		
		public boolean existe(int codigo) {
			
			return repositorioCliente.existe(codigo);
		}

		
		public ArrayList<Cliente> listar() {
			
			return repositorioCliente.listar();
			
		}	
}

