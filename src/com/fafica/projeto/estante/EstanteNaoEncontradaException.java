package com.fafica.projeto.estante;

public class EstanteNaoEncontradaException extends Exception {
	
	public EstanteNaoEncontradaException(){
		super("Estante n�o encontrada! Verifique o c�digo e tente novamente!");
	}

}
