package com.fafica.projeto.cliente;

import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {

	public static void main(String[] args) throws CampoObrigatorioInvalidoException {
			Fachada fachada = Fachada.getInstance();
			
			Cliente cliente = new Cliente("Lynneker",1);
			fachada.cadastrarCliente(cliente);
			
			Cliente cliente2 = new Cliente("Lynneker",1);
			fachada.cadastrarCliente(cliente2);
			
	
	}

}
