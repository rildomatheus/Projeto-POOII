package com.fafica.projeto.cliente;

public class ClienteJaCadastradoException extends Exception {
	
	public ClienteJaCadastradoException(){
		super ("Cliente J� Cadastrado");
	}
	
	public ClienteJaCadastradoException(String msg){
		super ("Cliente " + msg + " J� Cadastrado");
	}
}
