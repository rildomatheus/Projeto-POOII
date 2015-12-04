package com.fafica.projeto.caixa;

public class CaixaNaoEncontradaException extends Exception {

	public CaixaNaoEncontradaException(){
		super("Caixa Não Encontrada! Verifique o código e tente novamente");
	}
	
	public CaixaNaoEncontradaException(String msg){
		super("Caixa " +msg+ "Não Encontrada!!");
	}
}
