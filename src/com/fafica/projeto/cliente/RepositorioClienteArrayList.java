package com.fafica.projeto.cliente;

import java.util.ArrayList;

public class RepositorioClienteArrayList implements IRepositorioCliente{

	private ArrayList<Cliente> clientes;
	private int cod;
	
	public RepositorioClienteArrayList() {
		clientes = new ArrayList<Cliente>();
		cod = 1;
	}
	@Override
	public void cadastrarCliente(Cliente cliente) throws CampoObrigatorioInvalidoException {
		cliente.setCodigo(cod);
		clientes.add(cliente);
		cod++;
		
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public boolean removerCliente(Integer codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente procurarCliente(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeCliente(Integer codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
