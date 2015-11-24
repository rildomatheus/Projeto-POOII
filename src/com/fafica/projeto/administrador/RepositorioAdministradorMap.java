package com.fafica.projeto.administrador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepositorioAdministradorMap implements IRepositorioAdministrador {

	private Map<Integer, Administrador> adm;
	
	public RepositorioAdministradorMap(){
		
		adm = new HashMap<>();
	}

	public void cadastrar(Administrador administrador) throws AdministradorJaCadastradoException {
		if(existe(administrador.getCodigo())) throw new AdministradorJaCadastradoException();
		adm.put(administrador.getCodigo(), administrador);
	
		
	}


	public void atualizar(Administrador administrador) throws AdministradorNaoEncontradoException{
		if(existe(administrador.getCodigo())){
		adm.remove(administrador.getCodigo());
		adm.put(administrador.getCodigo(), administrador);
		
	 }else throw new AdministradorNaoEncontradoException();
		
 }

	public void remover(int codigo) throws AdministradorNaoEncontradoException {
		if(existe(codigo)){
			adm.remove(codigo);
		}else throw new AdministradorNaoEncontradoException();
	}


	public Administrador procurar(int codigo) throws AdministradorNaoEncontradoException {
		if(existe(codigo)){
			return adm.get(codigo);
		}else throw new AdministradorNaoEncontradoException();
	}

	
	public boolean existe(int codigo) {
		if(adm.containsKey(codigo)){
			return true;
		}
		return false;
	}

	
	public ArrayList<Administrador> listar() {
		ArrayList<Administrador>listar = new ArrayList<Administrador>();
		Set<Integer> keys = adm.keySet();
		for(Integer key : keys){
			listar.add(adm.get(key));
		}
		return listar;
	}

}
