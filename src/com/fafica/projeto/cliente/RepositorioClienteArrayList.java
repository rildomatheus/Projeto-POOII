package com.fafica.projeto.cliente;

import java.util.ArrayList;

import com.fafica.projeto.funcionario.Funcionario;
import com.fafica.projeto.funcionario.FuncionarioNaoEncontradoException;

public class RepositorioClienteArrayList implements IRepositorioCliente{

	private ArrayList<Cliente> arrayListCliente;
	
	
	public RepositorioClienteArrayList() {
		arrayListCliente = new ArrayList<Cliente>();
	
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException{
		if(existe(cliente.getCodigo())) throw new ClienteJaCadastradoException();
			arrayListCliente.add(cliente);
			
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		
		
		for(Cliente cliente1 : arrayListCliente){
			if(cliente1.getCodigo() == cliente.getCodigo()){
				arrayListCliente.remove(cliente1);
				arrayListCliente.add(cliente);
			}
		}
	}

	@Override
	public void remover(int codigo) throws ClienteNaoEncontradoException{
		
		if(existe(codigo)){
			Cliente clienteRemover = null;
			for(Cliente clienteBusca : arrayListCliente){
				if(clienteBusca.getCodigo() == codigo){
					clienteRemover = clienteBusca;
				}
			
			}
			arrayListCliente.remove(clienteRemover);
			System.out.println("Cliente removido com sucesso!");
		} else throw new ClienteNaoEncontradoException();	
	}

	@Override
	public Cliente procurar(int codigo) throws ClienteNaoEncontradoException{
		if(!existe(codigo))throw new ClienteNaoEncontradoException();
		for(Cliente clienteBusca : arrayListCliente){
			if(clienteBusca.getCodigo() == codigo){
				return clienteBusca;
			}
		}
		throw new ClienteNaoEncontradoException();
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
