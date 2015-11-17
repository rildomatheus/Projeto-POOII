package com.fafica.projeto.administrador;

public class AdministradorNaoEncontradoException extends Exception {
	
	public AdministradorNaoEncontradoException(){
		
		super("Ops!! Administrador nao encontrado! Tente novamente.");
	}

}
