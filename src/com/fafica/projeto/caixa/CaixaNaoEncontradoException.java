package com.fafica.projeto.caixa;

public class CaixaNaoEncontradoException extends Exception {

	public CaixaNaoEncontradoException(){
		super("Caixa N�o Encontrada!!");
	}
	
	public CaixaNaoEncontradoException(String msg){
		super("Caixa " +msg+ "N�o Encontrada!!");
	}
}
