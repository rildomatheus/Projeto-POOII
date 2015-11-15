package com.fafica.projeto.cliente;

import java.util.ArrayList;

public class RepositorioClienteArrayList implements IRepositorioCliente{

	private ArrayList<Cliente> arrayListCliente;
	
	
	public RepositorioClienteArrayList() {
		arrayListCliente = new ArrayList<Cliente>();
	
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException{
		if(!existe(cliente.getCodigo())){
			arrayListCliente.add(cliente);
		}else{
			throw new ClienteJaCadastradoException();
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		
		if(!existe(cliente.getCodigo())){
			throw new ClienteNaoEncontradoException();
		}
		for(Cliente clientes : arrayListCliente){
			if(clientes.getCodigo() == clientes.getCodigo()){
				arrayListCliente.remove(clientes);
				arrayListCliente.add(clientes);
			}
		}
	}

	@Override
	public void remover(int codigo) throws ClienteNaoEncontradoException{
	
		for(Cliente cliente : arrayListCliente){
			if(cliente.getCodigo() == codigo){
				arrayListCliente.remove(cliente);
			}
		}
	}

	@Override
	public Cliente procurar(int codigo) throws ClienteNaoEncontradoException{
		
		for(Cliente cliente : arrayListCliente){
			if(codigo == cliente.getCodigo()){
				return cliente;
			}
			else{
				throw new ClienteNaoEncontradoException();
			}
		}
		return null;
		
	}

	@Override
	public boolean existe(int codigo) {
		for(Cliente cliente : arrayListCliente){
			if(codigo == cliente.getCodigo()){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
	
		return arrayListCliente;
		
	}
}
