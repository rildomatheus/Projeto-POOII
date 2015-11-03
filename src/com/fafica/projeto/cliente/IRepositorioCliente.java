package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public interface IRepositorioCliente {

		public void cadastrar(Cliente cliente);
		public void atualizar(Cliente cliente);
		public boolean remover(int codigo);
		public Cliente procurar(int codigo);
		public boolean existe(int codigo);
		public ArrayList<Cliente> listar();
}
