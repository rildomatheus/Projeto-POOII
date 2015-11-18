package com.fafica.projeto.administrador;

import java.util.ArrayList;


public class RepositorioAdministradorArrayList implements IRepositorioAdministrador{
	
	private ArrayList<Administrador> arrayListAdministrador;
	//private int id;
	
	public RepositorioAdministradorArrayList(){
		
		arrayListAdministrador = new ArrayList<Administrador>();

		}
	
	public void cadastrar(Administrador administrador) throws AdministradorJaCadastradoException{
		if(existe(administrador.getCodigo())) throw new AdministradorJaCadastradoException();	
		arrayListAdministrador.add(administrador);
		System.out.println("Administrador cadastrado com sucesso!");
		
		
	}
	
	public void atualizar(Administrador administrador){
		
		for(Administrador administrador1 : arrayListAdministrador){
			if(administrador1.getCodigo() == administrador.getCodigo()){
				arrayListAdministrador.remove(administrador1);
				arrayListAdministrador.add(administrador);
				System.out.println("Administrador atualizador com sucesso!!");
				
			}
		}
	}
	
	public void remover(int codigo) throws AdministradorNaoEncontradoException{
		if(existe(codigo)){
		Administrador adm = null;
		for(Administrador administrador : arrayListAdministrador){
			if(administrador.getCodigo() == codigo){
				adm = administrador;
				
			  }	
			}
		  
		arrayListAdministrador.remove(adm);
		System.out.println("Administrador removido com sucesso!!");
		
		}else throw new AdministradorNaoEncontradoException();		
	}
	
	public Administrador procurar(int codigo) throws AdministradorNaoEncontradoException{
		if(existe(codigo)) throw new AdministradorNaoEncontradoException();
	    for(Administrador administrador : arrayListAdministrador){
	    	if(administrador.getCodigo() == codigo){
	    		return administrador;
	    	}	
	    }	
	    throw new AdministradorNaoEncontradoException();
	}
	
	public boolean existe(int codigo) {
		for(Administrador administrador : arrayListAdministrador){
			if(codigo == administrador.getCodigo()){
				return true;
			}
		}
		return false; 
	}
	
	
	public ArrayList<Administrador>listar(){
		
		return arrayListAdministrador;
		
	}

}



	
	

