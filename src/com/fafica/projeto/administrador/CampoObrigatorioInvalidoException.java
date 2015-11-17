package com.fafica.projeto.administrador;

public class CampoObrigatorioInvalidoException extends Exception{
	
	public CampoObrigatorioInvalidoException(String msg){
		
		super("Campo Obrigatorio " +msg+" Invalido ou Nulo!!" );		
	}
	
	

}
