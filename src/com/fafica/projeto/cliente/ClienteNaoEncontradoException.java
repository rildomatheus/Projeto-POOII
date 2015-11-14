package com.fafica.projeto.cliente;

public class ClienteNaoEncontradoException extends Exception {

	public ClienteNaoEncontradoException(){
		super ("Cliente N�o Encontrado");
	}
	
	public ClienteNaoEncontradoException(String msg){
		super ("Cliente" + msg + "N�o Encontrado");
	}
}
