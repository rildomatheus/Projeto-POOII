package com.fafica.projeto.cliente;

import java.util.ArrayList;


import com.fafica.projeto.cliente.IRepositorioCliente;
import com.fafica.projeto.cliente.RepositorioClienteArrayList;

	public class ControladorCliente{

		private IRepositorioCliente repositorioCliente;
		
		public ControladorCliente() {
			this.repositorioCliente = new RepositorioClienteArrayList();
		}
		
		
		public void cadastrar(Cliente cliente) throws CampoObrigatorioInvalidoException{
			
			
		    if (cliente.getNome().equals("")) throw new CampoObrigatorioInvalidoException("Campo Nome Invalido Ou Nulo");
		  
		    
		    this.repositorioCliente.cadastrarCliente(cliente);
			
		}

		
		public void atualizar(Cliente cliente) throws CampoObrigatorioInvalidoException {
			
			if (cliente.getNome() == "") throw new CampoObrigatorioInvalidoException("Campo Nome Invalido ou Nulo");
			
			this.repositorioCliente.atualizarCliente(cliente);
			
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

