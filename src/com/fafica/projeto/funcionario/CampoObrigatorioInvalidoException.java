package com.fafica.projeto.funcionario;

public class CampoObrigatorioInvalidoException extends Exception{
	
	public CampoObrigatorioInvalidoException(String msg){
		super ("Campo obrigat�rio "+msg+" inv�lido ou nulo");
	}

}
