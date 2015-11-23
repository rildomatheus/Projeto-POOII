package com.fafica.projeto.fachada;

import java.util.ArrayList;

import com.fafica.projeto.administrador.Administrador;
import com.fafica.projeto.administrador.AdministradorJaCadastradoException;
import com.fafica.projeto.administrador.AdministradorNaoEncontradoException;
import com.fafica.projeto.administrador.ControladorAdministrador;
import com.fafica.projeto.caixa.Caixa;
import com.fafica.projeto.caixa.CaixaJaCadastradaException;
import com.fafica.projeto.caixa.CaixaNaoEncontradaException;
import com.fafica.projeto.caixa.ControladorCaixa;
import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
import com.fafica.projeto.cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.cliente.ControladorCliente;
import com.fafica.projeto.estante.ControladorEstante;
import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.estante.EstanteJaCadastradaException;
import com.fafica.projeto.estante.EstanteNaoEncontradaException;
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
	private ControladorCaixa controladorCaixa;
	private ControladorEstante controladorEstante;
	
	
	private Fachada() {
		this.controladorCliente = new ControladorCliente();
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorCaixa = new ControladorCaixa();
		this.controladorEstante = new ControladorEstante();
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
	
	public ArrayList<Funcionario> listarFuncionario(){
		return this.controladorFuncionario.listar();
	}
	
	//Caixa
	
	public void cadastrarCaixa(Caixa caixa) throws CaixaJaCadastradaException, com.fafica.projeto.caixa.CampoObrigatorioInvalidoException, CampoObritarorioInvalidoException{
		this.controladorCaixa.cadastrar(caixa);
	}
	
	public void atualizarCaixa(Caixa caixa) throws CaixaNaoEncontradaException{
		this.controladorCaixa.atualizar(caixa);
	}
	
	public void removerCaixa(int codigo) throws CaixaNaoEncontradaException{
		this.controladorCaixa.remover(codigo);
	}
	
	public Caixa procurarCaixa(int codigo) throws CaixaNaoEncontradaException{
		return this.controladorCaixa.procurar(codigo);
	}
	
	public ArrayList<Caixa> listarCaixa(){
		return this.controladorCaixa.listar();
	}


	//Estante
	
	public void cadastrarEstante(Estante estante) throws IllegalArgumentException, CampoObrigatorioInvalidoException, EstanteJaCadastradaException{
		this.controladorEstante.cadastrar(estante);
	}
	
	public void atualizarEstante(Estante estante) throws IllegalArgumentException, CampoObrigatorioInvalidoException, EstanteNaoEncontradaException{
		this.controladorEstante.atualizar(estante);
	}
	
	public void removerEstante(int codigo) throws CampoObrigatorioInvalidoException, EstanteNaoEncontradaException{
		this.controladorEstante.remover(codigo);
	}
	
	public Estante procurarEstante(int codigo) throws CampoObrigatorioInvalidoException, EstanteNaoEncontradaException{
		return this.controladorEstante.procurar(codigo);
	}
	
	public ArrayList<Estante> listarEstante(){
		return this.controladorEstante.listar();
	}

}

