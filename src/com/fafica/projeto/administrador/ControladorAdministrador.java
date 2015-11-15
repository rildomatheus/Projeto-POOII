package com.fafica.projeto.administrador;

import java.util.ArrayList;

public class ControladorAdministrador {
	
	IRepositorioAdministrador repositorioAdministrador;
	
		public ControladorAdministrador(){
			this.repositorioAdministrador = new RepositorioAdministradorArrayList();
			
		}
		
		public void cadastrar(Administrador administrador){
			
			
			this.repositorioAdministrador.cadastrar(administrador);
		}

		public void atualizar(Administrador administrador){
			
			this.repositorioAdministrador.atualizar(administrador);
			
		}
		
		public void remover(int codigo){
			
			this.repositorioAdministrador.remover(codigo);
			
		}
		
		public Administrador procurar(int codigo){
			
			return repositorioAdministrador.procurar(codigo);
		}
		
		public boolean existe(int codigo){
			
			return repositorioAdministrador.existe(codigo);
		}
		
		public ArrayList<Administrador>listar(){
			
			return repositorioAdministrador.listar();
		}
	



}
