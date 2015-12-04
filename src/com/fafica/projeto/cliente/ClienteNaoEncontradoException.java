package com.fafica.projeto.cliente;

public class ClienteNaoEncontradoException extends Exception {

	public ClienteNaoEncontradoException(){
		super ("Cliente não encontrado! Verifique o código e tente novamente");
	}
	
	public ClienteNaoEncontradoException(String msg){
		super ("Cliente" + msg + "Não Encontrado");
	}
}
