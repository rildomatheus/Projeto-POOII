package com.fafica.projeto.funcionario;

import java.util.ArrayList;


public class ControladorFuncionario{
		
		
		private IRepositorioFuncionario repositorioFuncionario;
		
		public ControladorFuncionario(){
			repositorioFuncionario = new RepositorioFuncionarioIO();
		}
		
		public void cadastrar(Funcionario funcionario) throws IllegalArgumentException, CampoObrigatorioInvalidoException, FuncionarioJaCadastradoException{
			if(funcionario == null) throw new IllegalArgumentException("Funcionário Inválido!");
			if(funcionario.getNome().equals("")) throw new CampoObrigatorioInvalidoException("\"Nome\"");
			if(funcionario.getCodigo() == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			this.repositorioFuncionario.cadastrar(funcionario);
		}
		
		public void atualizar(Funcionario funcionario) throws IllegalArgumentException, CampoObrigatorioInvalidoException, FuncionarioNaoEncontradoException{
			if(funcionario == null) throw new IllegalArgumentException("Funcionário Inválido!");
			if(funcionario.getNome().equals("")) throw new CampoObrigatorioInvalidoException("\"Nome\"");
			if(funcionario.getCodigo() == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			this.repositorioFuncionario.atualizar(funcionario);
		}
		
		public void remover(int codigo) throws FuncionarioNaoEncontradoException, CampoObrigatorioInvalidoException{
			if(codigo == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			this.repositorioFuncionario.remover(codigo);
		}
		
		public Funcionario procurar(int codigo) throws FuncionarioNaoEncontradoException, CampoObrigatorioInvalidoException{
			if(codigo == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			return this.repositorioFuncionario.procurar(codigo);
			
		}
		
		public ArrayList<Funcionario> listar(){
			return this.repositorioFuncionario.listar();
		}
		

	
}


