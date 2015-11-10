package com.fafica.projeto.fachada;

import java.util.ArrayList;


import com.fafica.projeto.cliente.CampoObrigatorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ControladorCliente;

public class Fachada {
	
	private static Fachada instance;
	private ControladorCliente controladorCliente;
	
	
	private Fachada() {
		this.controladorCliente = new ControladorCliente();
	}

	// instanciando a fachada
	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	
	public void cadastrarCliente(Cliente cliente) throws  CampoObrigatorioInvalidoException{
		
		this.controladorCliente.cadastrar(cliente);
	    System.out.println(cliente);
	}

	public void atualizarCliente(Cliente cliente) throws CampoObrigatorioInvalidoException {
		
		this.controladorCliente.atualizar(cliente);
		System.out.println(cliente);
		
	}

	public boolean removerCliente(Integer codigo) {
		
		return false;
	}

	public Cliente procurarCliente(Integer codigo) {
		
		return null;
	}

	public boolean existeCliente(Integer codigo) {
		
		return false;
	}

	public ArrayList<Cliente> listar() {
		
		return null;
	}
	//Fim Metodos entidade cliente.

}
