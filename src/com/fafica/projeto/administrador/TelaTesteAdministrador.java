package com.fafica.projeto.administrador;

import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;

public class TelaTesteAdministrador {
	public static void main(String[] args){
		
		Administrador adm = new Administrador(ai,"Rildo Matheus");
		Administrador adm1 = new Administrador(3457,"Rildo Matheus");
		Administrador adm2 = new Administrador(3458,"Sr. Rildo Matheus");
		Fachada fachada = Fachada.getInstance();
		
	    //fachada.cadastrarAdministrador(adm);
		//fachada.cadastrarAdministrador(adm1);
		//fachada.cadastrarAdministrador(adm2);
		//fachada.atualizarAdministrador(adm2);
		///fachada.removerAdministrador(3458);
		//System.out.println(fachada.listarAdministrador());
		
		try {
			fachada.cadastrarAdministrador(adm);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (AdministradorJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e){
			System.out.println("ERROR!");
		}
	}

}
