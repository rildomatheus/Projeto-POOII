package com.fafica.projeto.funcionario;

public class FuncionarioNaoEncontradoException extends Exception{
	
	public FuncionarioNaoEncontradoException(){
		super("Funcionário não encontrado! Verifique o código e tente novamente.");
	}

}
