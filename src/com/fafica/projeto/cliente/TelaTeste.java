package com.fafica.projeto.cliente;

import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {

	public static void main(String[] args) throws ClienteNaoEncontradoException{
		
		Fachada fachada = Fachada.getInstance();
		Cliente cliente = new Cliente(1,"Bonanza",1);
		Cliente cliente2 = new Cliente(2,"Bonanza",1);
		
		try {
			fachada.cadastrarCliente(cliente);
		} catch (ClienteJaCadastradoException e) {
			System.out.println(e.getMessage());
		} catch (CampoObritarorioInvalidoException e) {
			System.out.println(e.getMessage());;
		}
		
		try {
			fachada.cadastrarCliente(cliente2);
		} catch (ClienteJaCadastradoException e) {	
			System.out.println(e.getMessage());;
		} catch (CampoObritarorioInvalidoException e) {	
			System.out.println(e.getMessage());;
		}
		
		System.out.println(fachada.listarCliente());
		System.out.println(fachada.existeCliente(2));
		fachada.removerCliente(1);
		System.out.println(fachada.listarCliente());
		
		
	}
}
