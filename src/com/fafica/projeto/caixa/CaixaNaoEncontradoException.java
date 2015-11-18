package com.fafica.projeto.caixa;

public class CaixaNaoEncontradoException extends Exception {

	public CaixaNaoEncontradoException(){
		super("Caixa Não Encontrada!!");
	}
	
	public CaixaNaoEncontradoException(String msg){
		super("Caixa " +msg+ "Não Encontrada!!");
	}
}
