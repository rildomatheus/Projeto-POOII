package com.fafica.projeto.funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RepositorioFuncionarioMap implements IRepositorioFuncionario {
	
	
	private Map<Integer, Funcionario> funcionarios;
	
	public RepositorioFuncionarioMap(){
		funcionarios = new HashMap<>();
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if(existe(funcionario.getCodigo())) throw new FuncionarioJaCadastradoException();
		funcionarios.put(funcionario.getCodigo(), funcionario);
		System.out.println("Funcionário cadastrado com sucesso!");
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if(existe(funcionario.getCodigo())){
			funcionarios.remove(funcionario.getCodigo());
			funcionarios.put(funcionario.getCodigo(), funcionario);
			System.out.println("Funcionário atualizado com sucesso!");
		}else throw new FuncionarioNaoEncontradoException();
	}
	
	public void remover(int codigo) throws FuncionarioNaoEncontradoException{
		if(existe(codigo)){
			funcionarios.remove(codigo);
			System.out.println("Funcionário removido com sucesso!");
		}else throw new FuncionarioNaoEncontradoException();
	}
	
	public Funcionario procurar(int codigo) throws FuncionarioNaoEncontradoException{
		if(existe(codigo)){
			return funcionarios.get(codigo);
		}else throw new FuncionarioNaoEncontradoException();
	}
	
	public boolean existe(int codigo){
		if(funcionarios.containsKey(codigo)){ 
			return true;
		}
		return false;
	}
	public List<Funcionario> listar(){
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		Set<Integer> keys = funcionarios.keySet();
		for(Integer key : keys){
			lista.add(funcionarios.get(key));
		}
		
		return lista;
	}
}


