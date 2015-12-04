package com.fafica.projeto.cliente;

public class ClienteNaoEncontradoException extends Exception {

	public ClienteNaoEncontradoException(){
		super ("Cliente n�o encontrado! Verifique o c�digo e tente novamente");
	}
	
	public ClienteNaoEncontradoException(String msg){
		super ("Cliente" + msg + "N�o Encontrado");
	}
}
