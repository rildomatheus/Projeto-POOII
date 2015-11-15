package com.fafica.projeto.funcionario;

import java.util.List;

public interface IRepositorioFuncionario {
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException;
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public void remover(int codigo) throws FuncionarioNaoEncontradoException;
	public Funcionario procurar(int codigo) throws FuncionarioNaoEncontradoException;
	public boolean existe(int codigo);
	public List<Funcionario> listar();

}
