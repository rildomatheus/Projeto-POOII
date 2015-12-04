package com.fafica.projeto.estante;

public class EstanteNaoEncontradaException extends Exception {
	
	public EstanteNaoEncontradaException(){
		super("Estante não encontrada! Verifique o código e tente novamente!");
	}

}
