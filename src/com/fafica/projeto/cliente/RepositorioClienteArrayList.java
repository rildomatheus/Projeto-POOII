package com.fafica.projeto.cliente;

import java.util.ArrayList;


public class RepositorioClienteArrayList implements IRepositorioCliente{

	private ArrayList<Cliente> arrayListCliente;
	private Integer cod;
	
	public RepositorioClienteArrayList() {
		arrayListCliente = new ArrayList<Cliente>();
		cod = 1;
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException{
		if (existe(cliente.getCodigo())) throw new ClienteJaCadastradoException();
		 cliente.setCodigo(cod);
		 arrayListCliente.add(cliente);
		 cod++;
		}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		
		int i = getId(cliente.getCodigo());
		if(i == -1)throw new ClienteNaoEncontradoException();
		arrayListCliente.add(i,cliente);
		
		
	}

	@Override
	public boolean remover(Integer codigo) throws ClienteNaoEncontradoException{
		
		int i = getId(codigo);
		if(i == -1) throw new ClienteNaoEncontradoException();
		arrayListCliente.remove(i);
		return true;
	}

	@Override
	public Cliente procurar(Integer codigo) throws ClienteNaoEncontradoException{
		
		int i = getId(codigo);
		if(i== -1) throw new ClienteNaoEncontradoException();
		return arrayListCliente.get(i);
	}

	@Override
	public boolean existe(Integer codigo) {

		boolean existe = false;
		for (Cliente cliente : arrayListCliente) {
			if(codigo.equals(cliente.getCodigo())){
				existe = true;
				return existe;
			}
		}
		return existe;
	}

	@Override
	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	   private int getId(Integer codigo) {
	        int aux = -1;
	        boolean aux1 = false;
	        for (int i = 0; !aux1 && (i < cod); i = i + 1) {
	            if (arrayListCliente.get(i).equals(codigo)) {
	                aux = i;
	                aux1 = true;
	            }
	        }
	        return aux;
	    }
}
