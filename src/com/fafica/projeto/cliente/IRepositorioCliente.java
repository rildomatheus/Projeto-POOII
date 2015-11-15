package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public interface IRepositorioCliente {

		public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException;
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
		public void remover(int codigo) throws ClienteNaoEncontradoException ;
		public Cliente procurar(int codigo) throws ClienteNaoEncontradoException;
		public boolean existe(int codigo);
		public ArrayList<Cliente> listar();
}
