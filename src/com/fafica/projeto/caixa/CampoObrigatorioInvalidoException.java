package com.fafica.projeto.caixa;

public class CampoObrigatorioInvalidoException extends Exception{
	
	public CampoObrigatorioInvalidoException(){
		super ("Campo Invalido ou Nulo!!");
	}
	
	public CampoObrigatorioInvalidoException(String msg){
		super ("Campo " +msg+ "Invalido ou Nulo!!" );
	}
}
