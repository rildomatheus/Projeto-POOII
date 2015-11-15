package com.fafica.projeto.funcionario;

public class CampoObrigatorioInvalidoException extends Exception{
	
	public CampoObrigatorioInvalidoException(String msg){
		super ("Campo obrigatório "+msg+" inválido ou nulo");
	}

}
