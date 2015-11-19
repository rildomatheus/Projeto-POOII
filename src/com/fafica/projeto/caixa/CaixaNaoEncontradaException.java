package com.fafica.projeto.caixa;

public class CaixaNaoEncontradaException extends Exception {

	public CaixaNaoEncontradaException(){
		super("Caixa Não Encontrada!!");
	}
	
	public CaixaNaoEncontradaException(String msg){
		super("Caixa " +msg+ "Não Encontrada!!");
	}
}
