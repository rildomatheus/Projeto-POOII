package com.fafica.projeto.estante;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RepositorioEstanteSet implements IRepositorioEstante{
	
	private Set<Estante> estanteSet;
	
	
	public RepositorioEstanteSet(){
		estanteSet = new HashSet<Estante>();
		
	}
	
	public void cadastrar(Estante estante) throws EstanteJaCadastradaException{
		if(existe(estante.getCodigo())) throw new EstanteJaCadastradaException();
		estanteSet.add(estante);
	
	}
		
	
	
	public void atualizar(Estante estante) throws EstanteNaoEncontradaException{
		if(existe(estante.getCodigo())){
			Estante estanteAtualizar = null;
			for(Estante estanteBusca : estanteSet){
				if(estanteBusca.getCodigo() == estante.getCodigo()){
					estanteAtualizar = estanteBusca;
				}
			}
			estanteSet.remove(estanteAtualizar);
			estanteSet.add(estante);
		
		}else throw new EstanteNaoEncontradaException();
	}
	
	public void remover(int codigo) throws EstanteNaoEncontradaException{
		if(existe(codigo)){
			Estante estanteRemover = null;
			for(Estante estanteBusca : estanteSet){
				if(estanteBusca.getCodigo() == codigo){
					estanteRemover = estanteBusca;
				}
			
			}
			estanteSet.remove(estanteRemover);
		
		} else throw new EstanteNaoEncontradaException();	
	}
	
	public Estante procurar(int codigo) throws EstanteNaoEncontradaException{
		if(!existe(codigo))throw new EstanteNaoEncontradaException();
		Estante estanteProcura = null; 
		for(Estante estanteBusca : estanteSet){
			if(estanteBusca.getCodigo() == codigo){
				estanteProcura = estanteBusca;
			}
		}
		return estanteProcura;
	}	
	

	public boolean existe(int codigo){
		for(Estante estanteBusca : estanteSet){
			if(estanteBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	//Lista os funcionários cadastrados	
	public ArrayList<Estante> listar(){
		ArrayList<Estante> lista = new ArrayList<Estante>();
		for(Estante estante : estanteSet){
			lista.add(estante);
		}
		return lista;
	}


}
