package com.fafica.projeto.cliente;

import java.util.ArrayList;

	public interface IRepositorioCliente {

		public void cadastrarCliente(Cliente cliente) throws CampoObrigatorioInvalidoException;
		public void atualizarCliente(Cliente cliente);
		public boolean removerCliente(Integer codigo);
		public Cliente procurarCliente(Integer codigo);
		public boolean existeCliente(Integer codigo);
		public ArrayList<Cliente> listar();
}
