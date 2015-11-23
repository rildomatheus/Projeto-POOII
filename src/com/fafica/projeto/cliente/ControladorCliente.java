package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public class ControladorCliente{

		private IRepositorioCliente repositorioCliente;
		
		public ControladorCliente() {
			this.repositorioCliente = new RepositorioClienteIo();
		
		}
				
		public void cadastrar(Cliente cliente)throws ClienteJaCadastradoException, CampoObritarorioInvalidoException{
			if (cliente.getCodigo() <= 0) throw new CampoObritarorioInvalidoException(" Codigo ");
			if (cliente.getNome() == null) throw new CampoObritarorioInvalidoException(" Nome ");
			if (cliente.getNome().equals("")) throw new CampoObritarorioInvalidoException(" Nome ");
			if (cliente.getLoja() <= 0) throw new CampoObritarorioInvalidoException(" Loja ");
		    repositorioCliente.cadastrar(cliente);	
		}
		
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException, CampoObritarorioInvalidoException  {
			
			if(!existe(cliente.getCodigo())) throw new ClienteNaoEncontradoException();
			if (cliente.getCodigo() <= 0) throw new CampoObritarorioInvalidoException(" Codigo ");
			if (cliente.getNome() == null) throw new CampoObritarorioInvalidoException(" Nome ");
			if (cliente.getNome().equals("")) throw new CampoObritarorioInvalidoException(" Nome ");
			if (cliente.getLoja() <= 0) throw new CampoObritarorioInvalidoException(" Loja ");
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

