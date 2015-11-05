package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public interface IRepositorioCliente {

		public void cadastrar(Cliente cliente);
		public void atualizar(Cliente cliente);
		public boolean remover(Integer codigo);
		public Cliente procurar(Integer codigo);
		public boolean existe(Integer codigo);
		public ArrayList<Cliente> listar();
}
