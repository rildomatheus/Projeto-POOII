package com.fafica.projeto.estante;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEstanteArrayList implements IRepositorioEstante{
	
	private List<Estante> estantes;
	
	
	public RepositorioEstanteArrayList(){
		estantes = new ArrayList<Estante>();
		
	}
	
	public void cadastrar(Estante estante) throws EstanteJaCadastradaException{
		if(existe(estante.getCodigo())) throw new EstanteJaCadastradaException();
		estantes.add(estante);
		System.out.println("Estante cadastrada com sucesso!");
	}
		
	
	
	public void atualizar(Estante estante) throws EstanteNaoEncontradaException{
		if(existe(estante.getCodigo())){
			Estante estanteAtualizar = null;
			for(Estante estanteBusca : estantes){
				if(estanteBusca.getCodigo() == estante.getCodigo()){
					estanteAtualizar = estanteBusca;
				}
			}
			estantes.remove(estanteAtualizar);
			estantes.add(estante);
			System.out.println("Estante atualizada com sucesso!");
		}else throw new EstanteNaoEncontradaException();
	}
	
	public void remover(int codigo) throws EstanteNaoEncontradaException{
		if(existe(codigo)){
			Estante estanteRemover = null;
			for(Estante estanteBusca : estantes){
				if(estanteBusca.getCodigo() == codigo){
					estanteRemover = estanteBusca;
				}
			
			}
			estantes.remove(estanteRemover);
			System.out.println("Estante removida com sucesso!");
		} else throw new EstanteNaoEncontradaException();	
	}
	
	public Estante procurar(int codigo) throws EstanteNaoEncontradaException{
		if(!existe(codigo))throw new EstanteNaoEncontradaException();
		Estante estanteProcura = null; 
		for(Estante estanteBusca : estantes){
			if(estanteBusca.getCodigo() == codigo){
				estanteProcura = estanteBusca;
			}
		}
		return estanteProcura;
	}	
	

	public boolean existe(int codigo){
		for(Estante estanteBusca : estantes){
			if(estanteBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	//Lista os funcionários cadastrados	
	public List<Estante> listar(){
		return estantes;
	}

}
