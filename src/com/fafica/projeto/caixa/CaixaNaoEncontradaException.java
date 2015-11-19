package com.fafica.projeto.caixa;

public class CaixaNaoEncontradaException extends Exception {

	public CaixaNaoEncontradaException(){
		super("Caixa N�o Encontrada!!");
	}
	
	public CaixaNaoEncontradaException(String msg){
		super("Caixa " +msg+ "N�o Encontrada!!");
	}
}
