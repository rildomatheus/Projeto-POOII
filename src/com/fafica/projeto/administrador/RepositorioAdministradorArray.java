package com.fafica.projeto.administrador;

import java.util.ArrayList;

public class RepositorioAdministradorArray implements IRepositorioAdministrador{
	
	private ArrayList<Administrador> arrayListAdministrador;
	private int id;
	
	public RepositorioAdministradorArray(){
		
		arrayListAdministrador = new ArrayList<Administrador>();
		id = 1;

		}
	
	public void cadastrar(Administrador administrador) {
	
		administrador.setCodigo(id);
		arrayListAdministrador.add(administrador);
		id++;
		
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



	
	

