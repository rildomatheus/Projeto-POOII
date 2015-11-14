package com.fafica.projeto.cliente;

public class CampoObritarorioInvalidoException extends Exception {

	public CampoObritarorioInvalidoException(){
		super ("Campo Nulo ou Invalido");
	}
	
	public CampoObritarorioInvalidoException(String msg){
		super ("Campo" + msg + "Nulo ou Invalido");
	}
}
