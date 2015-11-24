package com.fafica.projeto.administrador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fafica.projeto.funcionario.Funcionario;

public class RepositorioAdministradorSet implements IRepositorioAdministrador{
	private Set<Administrador> adm;
	
	public RepositorioAdministradorSet(){
	
		adm = new HashSet<Administrador>();
		
	}

	public void cadastrar(Administrador administrador) throws AdministradorJaCadastradoException {
		if(existe(administrador.getCodigo())) throw new AdministradorJaCadastradoException();
		adm.add(administrador);
		
	}

	
	public void atualizar(Administrador administrador) throws AdministradorNaoEncontradoException {
		
		if(existe(administrador.getCodigo())){
			Administrador administradorAtualizar = null;
			for(Administrador administradorBusca : adm){
				if(administradorBusca.getCodigo() == administrador.getCodigo()){
					administradorAtualizar = administradorBusca;
	        }
		  }
			
			adm.remove(administradorAtualizar);
			adm.add(administrador);
		
	   }else throw new AdministradorNaoEncontradoException();
	}

	
	public void remover(int codigo) throws AdministradorNaoEncontradoException {
		if(existe(codigo)){
		Administrador administradorRemove = null;
		for(Administrador administradorBusca : adm){
			if(administradorBusca.getCodigo() == codigo){
				administradorRemove =administradorBusca;
			}
		}
			adm.remove(administradorRemove);
		
		} else throw new  AdministradorNaoEncontradoException();
	}
		

	
	public Administrador procurar(int codigo) throws AdministradorNaoEncontradoException {
		if(!existe(codigo)) throw new AdministradorNaoEncontradoException();
		Administrador administradorProcura = null;
		
		for(Administrador administradorBusca : adm){
			if(administradorBusca.getCodigo() == codigo){
				administradorProcura = administradorBusca;
			}
		}
		return administradorProcura;
	}

	
	public boolean existe(int codigo) {
		for(Administrador administradorBusca : adm){
			if(administradorBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}

	
	public ArrayList<Administrador> listar() {
		ArrayList<Administrador> lista = new ArrayList<Administrador>();
		for(Administrador administrador : adm){
			lista.add(administrador);
		}
      return lista;
	}

}
