package com.fafica.projeto.estante;

import java.util.ArrayList;

import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;

public class ControladorEstante {
	
	private IRepositorioEstante repositorioEstante;
	
	public ControladorEstante(){
		repositorioEstante = new RepositorioEstanteIO();
	}
	
	public void cadastrar(Estante estante) throws IllegalArgumentException, CampoObrigatorioInvalidoException, EstanteJaCadastradaException{
		if(estante == null) throw new IllegalArgumentException("Funcionário Inválido!");
		if(estante.getRua().equals("")) throw new CampoObrigatorioInvalidoException("\"Nome\"");
		if(estante.getCodigo() == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
		this.repositorioEstante.cadastrar(estante);
	}
	
	public void atualizar(Estante estante) throws IllegalArgumentException, CampoObrigatorioInvalidoException, EstanteNaoEncontradaException{
		if(estante == null) throw new IllegalArgumentException("Funcionário Inválido!");
		if(estante.getRua().equals("")) throw new CampoObrigatorioInvalidoException("\"Nome\"");
		if(estante.getCodigo() == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
		this.repositorioEstante.atualizar(estante);
	}
	
	public void remover(int codigo) throws CampoObrigatorioInvalidoException, EstanteNaoEncontradaException{
		if(codigo == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
		this.repositorioEstante.remover(codigo);
	}
	
	public Estante procurar(int codigo) throws CampoObrigatorioInvalidoException, EstanteNaoEncontradaException{
		if(codigo == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
		return this.repositorioEstante.procurar(codigo);
		
	}
	
	public ArrayList<Estante> listar(){
		return this.repositorioEstante.listar();
	}
	
}
