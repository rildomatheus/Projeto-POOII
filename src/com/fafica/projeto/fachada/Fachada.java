package com.fafica.projeto.fachada;

import java.util.ArrayList;

import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
import com.fafica.projeto.cliente.ClienteNaoEncontradoException;
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
	
	// Inicio CRUD Cliente
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException, CampoObritarorioInvalidoException  {
		
		this.controladorCliente.cadastrar(cliente);
		
		
	}

	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException  {
		
		this.controladorCliente.atualizar(cliente);
	}

	public void removerCliente(Integer codigo) throws ClienteNaoEncontradoException{
		
		 this.controladorCliente.remover(codigo);
	}

	public Cliente procurarCliente(Integer codigo) throws ClienteNaoEncontradoException{

		return controladorCliente.procurar(codigo);

	}
	
	public boolean existeCliente(Integer codigo) {

		return controladorCliente.existe(codigo);
	}

	public ArrayList<Cliente> listarCliente() {

		return controladorCliente.listar();

	}

	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}

	public void setControladorCliente(
			ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}
	//Fim CRUD Cliente.

}
