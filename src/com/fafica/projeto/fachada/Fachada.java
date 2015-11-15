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
		
		controladorCliente.cadastrar(cliente);
	}

	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException  {
		
		controladorCliente.atualizar(cliente);
	}

	public void removerCliente(int codigo) throws ClienteNaoEncontradoException, CampoObritarorioInvalidoException{
		
		  controladorCliente.remover(codigo);
	}

	public Cliente procurarCliente(int codigo) throws ClienteNaoEncontradoException{

		return controladorCliente.procurar(codigo);

	}
	
	public boolean existeCliente(int codigo) {

		return controladorCliente.existe(codigo);
	}

	public ArrayList<Cliente> listarCliente() {

		return controladorCliente.listar();

	}
	//Fim CRUD Cliente.

}
