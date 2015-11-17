package com.fafica.projeto.cliente;

import java.util.ArrayList;

import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {

	public static void main(String[] args) {
		
		Fachada fachada = Fachada.getInstance();
		Cliente cliente = new Cliente(1,"Bonanza",-1);
		Cliente cliente2 = new Cliente(-2,"Claro",1);
	
		
		try {
			fachada.cadastrarCliente(cliente);
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (CampoObritarorioInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			fachada.cadastrarCliente(cliente2);
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (CampoObritarorioInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	
		ArrayList<Cliente> clientes = fachada.listarCliente();
		for(Cliente c: clientes) {
			System.out.println(c);
		}
		
		try {
			fachada.removerCliente(1);
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (CampoObritarorioInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(fachada.procurarCliente(2));
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
