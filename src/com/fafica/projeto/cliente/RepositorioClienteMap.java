package com.fafica.projeto.cliente;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class RepositorioClienteMap implements IRepositorioCliente{
	Map<Integer, Cliente> clienteMap;
	
	public RepositorioClienteMap(){
		clienteMap = new TreeMap<Integer, Cliente>();
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if (existe(cliente.getCodigo())) throw new ClienteJaCadastradoException();
		clienteMap.put(cliente.getCodigo() , cliente);
		System.out.println("Cliente Cadastrado Com Sucesso!!");
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		if(existe(cliente.getCodigo())){
			clienteMap.remove(cliente.getCodigo());
			clienteMap.put(cliente.getCodigo(), cliente);
			System.out.println("Cliente Atualizado Com Sucesso!!");
		}else throw new ClienteNaoEncontradoException();
		
	}

	@Override
	public void remover(int codigo) throws ClienteNaoEncontradoException {
		if(existe(codigo)){
			clienteMap.remove(codigo);
			System.out.println("Cliente Removido Com Sucesso!!");
		}else throw new ClienteNaoEncontradoException();
		
	}

	@Override
	public Cliente procurar(int codigo) throws ClienteNaoEncontradoException {
		if(existe(codigo)){
			return clienteMap.get(codigo);
		}else throw new ClienteNaoEncontradoException();
	}

	@Override
	public boolean existe(int codigo) {
		if(clienteMap.containsKey(codigo)){ 
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Set<Integer> keys = clienteMap.keySet();
		for(Integer key : keys){
			lista.add(clienteMap.get(key));
		}
		
		return lista;
	}
}
