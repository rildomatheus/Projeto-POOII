package com.fafica.projeto.cliente;

import java.util.ArrayList;

public class RepositorioClienteArrayList implements IRepositorioCliente{

	private ArrayList<Cliente> cliente;
	private int cod;
	
	public RepositorioClienteArrayList() {
		cliente = new ArrayList<Cliente>();
		cod = 1;
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteInvalidoException {
		cliente.setCodigo(cod);
		cliente.add(cliente);
		cod++;
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remover(Integer codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente procurar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Integer codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
