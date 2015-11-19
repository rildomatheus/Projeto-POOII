package com.fafica.projeto.estante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepositorioEstanteMap implements IRepositorioEstante{
private Map<Integer, Estante> estanteMap;
	
	public RepositorioEstanteMap(){
		estanteMap = new HashMap<>();
	}
	
	public void cadastrar(Estante estante) throws EstanteJaCadastradaException{
		if(existe(estante.getCodigo())) throw new EstanteJaCadastradaException();
		estanteMap.put(estante.getCodigo(), estante);
		System.out.println("Estante cadastrada com sucesso!");
	}
	
	public void atualizar(Estante estante) throws EstanteNaoEncontradaException{
		if(existe(estante.getCodigo())){
			estanteMap.remove(estante.getCodigo());
			estanteMap.put(estante.getCodigo(), estante);
			System.out.println("Estante atualizada com sucesso!");
		}else throw new EstanteNaoEncontradaException();
	}
	
	public void remover(int codigo) throws EstanteNaoEncontradaException{
		if(existe(codigo)){
			estanteMap.remove(codigo);
			System.out.println("Estante removida com sucesso!");
		}else throw new EstanteNaoEncontradaException();
	}
	
	public Estante procurar(int codigo) throws EstanteNaoEncontradaException{
		if(existe(codigo)){
			return estanteMap.get(codigo);
		}else throw new EstanteNaoEncontradaException();
	}
	
	public boolean existe(int codigo){
		if(estanteMap.containsKey(codigo)){ 
			return true;
		}
		return false;
	}
	public List<Estante> listar(){
		ArrayList<Estante> lista = new ArrayList<Estante>();
		Set<Integer> keys = estanteMap.keySet();
		for(Integer key : keys){
			lista.add(estanteMap.get(key));
		}
		
		return lista;
	}

}
