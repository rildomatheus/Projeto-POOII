package com.fafica.projeto.cliente;

import java.util.ArrayList;
import java.util.HashSet;

public class RepositorioClienteSet implements IRepositorioCliente{
	HashSet<Cliente> clienteSet;
	
	public RepositorioClienteSet(){
		clienteSet = new HashSet<Cliente>();
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if(existe(cliente.getCodigo())) throw new ClienteJaCadastradoException();
		clienteSet.add(cliente);
		
	}
		

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		if(existe(cliente.getCodigo())){
			Cliente clienteAtualizar = null;
			for(Cliente clienteBuscar : clienteSet){
				if(clienteBuscar.getCodigo() == cliente.getCodigo()){
					clienteAtualizar = clienteBuscar;
				}
			}
			clienteSet.remove(clienteAtualizar);
			clienteSet.add(cliente);
			
		}else throw new ClienteNaoEncontradoException();
		
	}

	@Override
	public void remover(int codigo) throws ClienteNaoEncontradoException {
		if(existe(codigo)){
			Cliente clienteRemover = null;
			for(Cliente clienteBuscar : clienteSet){
				if(clienteBuscar.getCodigo() == codigo){
					clienteRemover = clienteBuscar;
				}
			
			}
			clienteSet.remove(clienteRemover);
			
		} else throw new ClienteNaoEncontradoException();	
	}

	@Override
	public Cliente procurar(int codigo) throws ClienteNaoEncontradoException {
		if(!existe(codigo)) throw new ClienteNaoEncontradoException();
		Cliente clienteProcura = null; 
		
		for(Cliente clienteBuscar : clienteSet){
			if(clienteBuscar.getCodigo() == codigo){
				clienteProcura = clienteBuscar;
			}
		}
		return clienteProcura;
	}

	@Override
	public boolean existe(int codigo) {
		for(Cliente clienteBuscar : clienteSet){
			if(clienteBuscar.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	

	@Override
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		for(Cliente cliente : clienteSet){
			list.add(cliente);
		}
		return list;
	}
	

}
