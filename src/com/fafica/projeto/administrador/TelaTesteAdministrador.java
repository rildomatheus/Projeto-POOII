package com.fafica.projeto.administrador;

import com.fafica.projeto.fachada.Fachada;

public class TelaTesteAdministrador {
	public static void main(String[] args){
		
		Administrador adm = new Administrador(3456,"Rildo Matheus");
		Administrador adm1 = new Administrador(3457,"Rildo Matheus");
		Administrador adm2 = new Administrador(3458,"Rildo Matheus");
		Fachada fachada = Fachada.getInstance();
		
		fachada.cadastrarAdministrador(adm);
		fachada.cadastrarAdministrador(adm1);
		fachada.cadastrarAdministrador(adm2);
		System.out.println(fachada.listarAdministrador());
	}

}
