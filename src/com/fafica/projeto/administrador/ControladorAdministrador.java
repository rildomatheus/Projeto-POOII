package com.fafica.projeto.administrador;

import java.util.ArrayList;

public class ControladorAdministrador {
	
	IRepositorioAdministrador repositorioAdministrador;
	
		public ControladorAdministrador(){
			this.repositorioAdministrador = new RepositorioAdministradorIO();
			
		}
		
		public void cadastrar(Administrador administrador) throws IllegalArgumentException, CampoObrigatorioInvalidoException, AdministradorJaCadastradoException{
			if(administrador == null) throw new IllegalArgumentException("Administrador Invalido!!");
			if(administrador.getNome().equals(" ")) throw new CampoObrigatorioInvalidoException("\"Nome\"");
			if(administrador.getCodigo() == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			this.repositorioAdministrador.cadastrar(administrador);
		}

		public void atualizar(Administrador administrador) throws IllegalArgumentException, CampoObrigatorioInvalidoException, AdministradorNaoEncontradoException{
			if(administrador == null) throw new IllegalArgumentException("Administrador Invalido");
			if(administrador.getNome().equals(" ")) throw new CampoObrigatorioInvalidoException("\"Nome\"");
			if(administrador.getCodigo() ==0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			this.repositorioAdministrador.atualizar(administrador);
			
		}
		
		public void remover(int codigo) throws AdministradorNaoEncontradoException, CampoObrigatorioInvalidoException{
			if(codigo == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			this.repositorioAdministrador.remover(codigo);
			
		}
		
		public Administrador procurar(int codigo)throws AdministradorNaoEncontradoException, CampoObrigatorioInvalidoException{
			if(codigo == 0) throw new CampoObrigatorioInvalidoException("\"Código\"");
			return repositorioAdministrador.procurar(codigo);
		}
		
		public boolean existe(int codigo) {
			
			return repositorioAdministrador.existe(codigo);
		}
		
		public ArrayList<Administrador>listar(){
			
			return repositorioAdministrador.listar();
		}
	



}
