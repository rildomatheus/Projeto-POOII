package com.fafica.projeto.funcionario;

public class FuncionarioNaoEncontradoException extends Exception{
	
	public FuncionarioNaoEncontradoException(){
		super("Funcion�rio n�o encontrado! Verifique o c�digo e tente novamente.");
	}

}
