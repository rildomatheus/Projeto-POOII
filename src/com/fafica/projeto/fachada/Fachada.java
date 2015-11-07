package com.fafica.projeto.fachada;

import java.util.ArrayList;


import com.fafica.projeto.cliente.CampoObrigatorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteInvalidoException;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
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
	
	
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException,ClienteInvalidoException, CampoObrigatorioInvalidoException{
		
		this.controladorCliente.cadastrar(cliente);
	    
	  
	}

	public void atualizar(Cliente cliente) {
		
		
	}

	public boolean remover(Integer codigo) {
		
		return false;
	}

	public Cliente procurar(Integer codigo) {
		
		return null;
	}

	public boolean existe(Integer codigo) {
		
		return false;
	}

	public ArrayList<Cliente> listar() {
		
		return null;
	}
	//Fim Metodos entidade cliente.
}
