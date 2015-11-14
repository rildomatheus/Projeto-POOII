package com.fafica.projeto.cliente;

import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {

	public static void main(String[] args) throws ClienteJaCadastradoException, CampoObritarorioInvalidoException, ClienteNaoEncontradoException {
		
		Fachada fachada = Fachada.getInstance();
		
		Cliente cliente = new Cliente(1,"eu",1);
		fachada.cadastrarCliente(cliente);
		
		System.out.println(fachada.listarCliente());
//		System.out.println();
//		System.out.println(fachada.existeCliente(1));
		
		
		
	}
}
