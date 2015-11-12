package com.fafica.projeto.fachada;

import java.util.ArrayList;

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
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException  {
		
		this.controladorCliente.cadastrar(cliente);
		
		
	}

	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException  {
		
		this.controladorCliente.atualizar(cliente);
	}

	public boolean removerCliente(Integer codigo) throws ClienteNaoEncontradoException{
		
		return false;
	}

	public Cliente procurarFornecedor(Integer codigo) throws ClienteNaoEncontradoException{

		return controladorCliente.procurar(codigo);

	}

	public ArrayList<Cliente> listaCliente() {

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
