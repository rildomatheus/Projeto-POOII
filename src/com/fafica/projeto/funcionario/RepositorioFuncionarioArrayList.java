package com.fafica.projeto.funcionario;

import java.util.ArrayList;


public class RepositorioFuncionarioArrayList implements IRepositorioFuncionario {
	
	private ArrayList<Funcionario> funcionarios;
	
	
	public RepositorioFuncionarioArrayList(){
		funcionarios = new ArrayList<Funcionario>();
		
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if(existe(funcionario.getCodigo())) throw new FuncionarioJaCadastradoException();
		funcionarios.add(funcionario);
		
	}
		
	
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if(existe(funcionario.getCodigo())){
			Funcionario funcionarioAtualizar = null;
			for(Funcionario funcionarioBusca : funcionarios){
				if(funcionarioBusca.getCodigo() == funcionario.getCodigo()){
					funcionarioAtualizar = funcionarioBusca;
				}
			}
			funcionarios.remove(funcionarioAtualizar);
			funcionarios.add(funcionario);
		
		}else throw new FuncionarioNaoEncontradoException();
	}
		//System.out.println(funcionarios.indexOf(funcionario.codigo));
	
	public void remover(int codigo) throws FuncionarioNaoEncontradoException{
		if(existe(codigo)){
			Funcionario funcionarioRemover = null;
			for(Funcionario funcionarioBusca : funcionarios){
				if(funcionarioBusca.getCodigo() == codigo){
					funcionarioRemover = funcionarioBusca;
				}
			
			}
			funcionarios.remove(funcionarioRemover);
		
		} else throw new FuncionarioNaoEncontradoException();	
	}
	
	public Funcionario procurar(int codigo) throws FuncionarioNaoEncontradoException{
		if(!existe(codigo))throw new FuncionarioNaoEncontradoException();
		Funcionario funcionarioProcura = null; 
		
		for(Funcionario funcionarioBusca : funcionarios){
			if(funcionarioBusca.getCodigo() == codigo){
				funcionarioProcura = funcionarioBusca;
			}
		}
		return funcionarioProcura;
	}	
	

	public boolean existe(int codigo){
		for(Funcionario funcionarioBusca : funcionarios){
			if(funcionarioBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	//Lista os funcionários cadastrados	
	public ArrayList<Funcionario> listar(){
		return funcionarios;
	}

}
