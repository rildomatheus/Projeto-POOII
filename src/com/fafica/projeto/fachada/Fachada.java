package com.fafica.projeto.fachada;

import java.util.ArrayList;
import java.util.List;

import com.fafica.projeto.administrador.Administrador;
import com.fafica.projeto.administrador.AdministradorJaCadastradoException;
import com.fafica.projeto.administrador.AdministradorNaoEncontradoException;
import com.fafica.projeto.administrador.ControladorAdministrador;
import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
import com.fafica.projeto.cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.cliente.ControladorCliente;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;
import com.fafica.projeto.funcionario.ControladorFuncionario;
import com.fafica.projeto.funcionario.Funcionario;
import com.fafica.projeto.funcionario.FuncionarioJaCadastradoException;
import com.fafica.projeto.funcionario.FuncionarioNaoEncontradoException;

public class Fachada {
	
	private static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorAdministrador controladorAdministrador;
	private ControladorFuncionario controladorFuncionario;
	
	
	private Fachada() {
		this.controladorCliente = new ControladorCliente();
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorFuncionario = new ControladorFuncionario();
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

	public void removerCliente(int codigo) throws ClienteNaoEncontradoException, CampoObritarorioInvalidoException{
		
		  this.controladorCliente.remover(codigo);
	}

	public Cliente procurarCliente(int codigo) throws ClienteNaoEncontradoException{

		return this.controladorCliente.procurar(codigo);

	}
	
	public boolean existeCliente(int codigo) {

		return this.controladorCliente.existe(codigo);
	}

	public ArrayList<Cliente> listarCliente() {

		return controladorCliente.listar();

	}
	//Fim CRUD Cliente.
  
	//Inicio CRUD Administrador.
	
	public void cadastrarAdministrador(Administrador administrador) throws IllegalArgumentException, AdministradorJaCadastradoException, CampoObrigatorioInvalidoException, com.fafica.projeto.administrador.CampoObrigatorioInvalidoException{
	
		this.controladorAdministrador.cadastrar(administrador);
		
	}
	
	public void atualizarAdministrador(Administrador administrador) throws IllegalArgumentException, AdministradorNaoEncontradoException, com.fafica.projeto.administrador.CampoObrigatorioInvalidoException{
		
		this.controladorAdministrador.atualizar(administrador);
		
	}
	
	public void removerAdministrador(int codigo) throws AdministradorNaoEncontradoException, com.fafica.projeto.administrador.CampoObrigatorioInvalidoException{
		
		this.controladorAdministrador.remover(codigo);
	}
	
	public Administrador procurarAdministrador(int codigo) throws AdministradorNaoEncontradoException, com.fafica.projeto.administrador.CampoObrigatorioInvalidoException{
		
		return this.controladorAdministrador.procurar(codigo);
	}
	
	public boolean existeAdministrador(int codigo){
		
		return this.controladorAdministrador.existe(codigo);
	}
	
	public ArrayList<Administrador> listarAdministrador(){
		
		return this.controladorAdministrador.listar();
	}

	//Fim CRUD administrador.
	
	//Funcionário
	
	public void cadastrarFuncionario(Funcionario funcionario) throws IllegalArgumentException, CampoObrigatorioInvalidoException, FuncionarioJaCadastradoException{
		this.controladorFuncionario.cadastrar(funcionario);
	}
	
	public void atualizarFuncionario(Funcionario funcionario) throws IllegalArgumentException, CampoObrigatorioInvalidoException, FuncionarioNaoEncontradoException{
		this.controladorFuncionario.atualizar(funcionario);
	}
	
	public void removerFuncionario(Integer codigo) throws FuncionarioNaoEncontradoException, CampoObrigatorioInvalidoException{
		this.controladorFuncionario.remover(codigo);
	}
	
	public Funcionario procurarFuncionario(Integer codigo) throws FuncionarioNaoEncontradoException, CampoObrigatorioInvalidoException{
		return this.controladorFuncionario.procurar(codigo);
	}
	
	public List<Funcionario> listarFuncionario(){
		return this.controladorFuncionario.listar();
	}
}

