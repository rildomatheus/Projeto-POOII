package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public interface IRepositorioCliente {

		public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException ;
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
		public boolean remover(Integer codigo) throws ClienteNaoEncontradoException;
		public Cliente procurar(Integer codigo) throws ClienteNaoEncontradoException;
		public boolean existe(Integer codigo);
		public ArrayList<Cliente> listar();
}
