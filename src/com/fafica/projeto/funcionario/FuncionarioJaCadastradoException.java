package com.fafica.projeto.funcionario;

public class FuncionarioJaCadastradoException extends Exception {
	
	public FuncionarioJaCadastradoException(){
		super("Funcionário já cadastrado!");
	}

}
