package com.fafica.projeto.administrador;

public class AdministradorNaoEncontradoException extends Exception {
	
	public AdministradorNaoEncontradoException(){
		
		super("Administrador nao encontrado! Verifique o código e tente novamente.");
	}

}
