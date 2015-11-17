package com.fafica.projeto.administrador;

import java.util.ArrayList;

public class RepositorioAdministradorArrayList implements IRepositorioAdministrador{
	
	private ArrayList<Administrador> arrayListAdministrador;
	private int id;
	
	public RepositorioAdministradorArrayList(){
		
		arrayListAdministrador = new ArrayList<Administrador>();

		}
	
	public void cadastrar(Administrador administrador) {
	
		arrayListAdministrador.add(administrador);
		
	}
	
	public void atualizar(Administrador administrador){
		
		for(Administrador administrador1 : arrayListAdministrador){
			if(administrador1.getCodigo() == administrador.getCodigo()){
				arrayListAdministrador.remove(administrador1);
				arrayListAdministrador.add(administrador);
				
			}
		}
	}
	
	public void remover(int codigo){
		
		for(Administrador administrador : arrayListAdministrador){
			if(administrador.getCodigo() == codigo){
				arrayListAdministrador.remove(administrador);
				
				
			}
		}
	

	}
	
	public Administrador procurar(int codigo){
		
	    for(Administrador administrador : arrayListAdministrador){
	    	if(administrador.getCodigo() == codigo){
	    		return administrador;
	    	}	
	    }
		return null; //tratar exceçao	
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



	
	

