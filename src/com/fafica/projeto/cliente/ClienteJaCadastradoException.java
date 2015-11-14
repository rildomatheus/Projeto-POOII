package com.fafica.projeto.cliente;

public class ClienteJaCadastradoException extends Exception {
	
	public ClienteJaCadastradoException(){
		super ("Cliente Já Cadastrado");
	}
	
	public ClienteJaCadastradoException(String msg){
		super ("Cliente " + msg + " Já Cadastrado");
	}
}
