package com.fafica.projeto.cliente;

import java.util.ArrayList;

public class RepositorioClienteArrayList implements IRepositorioCliente{

	private ArrayList<Cliente> arrayListCliente;
	private int id;
	
	public RepositorioClienteArrayList() {
		arrayListCliente = new ArrayList<Cliente>();
		id = 1;
	}
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException, CampoObritarorioInvalidoException{
		
		if (cliente.getNome() == null) throw new CampoObritarorioInvalidoException(" Nome ");
		if (cliente.getNome() == " ") throw new CampoObritarorioInvalidoException(" Nome ");
		 arrayListCliente.add(cliente);
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
	
	   private int getId(int codigo) {
	        int aux = -1;
	        boolean aux1 = false;
	        for (int i = 0; !aux1 && (i < id); i = i + 1) {
	            if (arrayListCliente.get(i).equals(codigo)) {
	                aux = i;
	                aux1 = true;
	            }
	        }
	        return aux;
	    }
}
