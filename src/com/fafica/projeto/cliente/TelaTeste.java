package com.fafica.projeto.cliente;

import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {

	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();
		Cliente cliente1 = new Cliente(1,"Bonanza",1);
		Cliente cliente2 = new Cliente(2,"Claro",1);
		
		try {
			fachada.cadastrarCliente(cliente1);
			fachada.cadastrarCliente(cliente2);
		} catch (ClienteJaCadastradoException e) {
			System.out.println(e.getMessage());

		} catch (CampoObritarorioInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(fachada.listarCliente());
	}

}
