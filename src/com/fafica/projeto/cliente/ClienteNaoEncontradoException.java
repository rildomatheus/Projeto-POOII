package com.fafica.projeto.cliente;

public class ClienteNaoEncontradoException extends Exception {

	public ClienteNaoEncontradoException(){
		super ("Cliente Não Encontrado");
	}
	
	public ClienteNaoEncontradoException(String msg1){
		super ("Cliente" + msg1 + "Não Encontrado");
	}
}
