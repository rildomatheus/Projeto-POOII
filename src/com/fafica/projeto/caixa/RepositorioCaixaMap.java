package com.fafica.projeto.caixa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RepositorioCaixaMap implements IRepositorioCaixa {
	HashMap<Integer, Caixa> caixaMap;
	
	public RepositorioCaixaMap(){
		caixaMap = new HashMap<Integer, Caixa>();
	}
	
	@Override
	public void cadastrar(Caixa caixa) throws CaixaJaCadastradaException {
		if (existe(caixa.getCodigo())) throw new CaixaJaCadastradaException();
		caixaMap.put(caixa.getCodigo() , caixa);
		
	}

	@Override
	public void atualizar(Caixa caixa) throws CaixaNaoEncontradaException {
		if(existe(caixa.getCodigo())){
			caixaMap.remove(caixa.getCodigo());
			caixaMap.put(caixa.getCodigo(), caixa);
		
		}else throw new CaixaNaoEncontradaException();
	}

	@Override
	public void remover(int codigo) throws CaixaNaoEncontradaException {
		if(existe(codigo)){
			caixaMap.remove(codigo);
		
		}else throw new CaixaNaoEncontradaException();
		
	}

	@Override
	public Caixa procurar(int codigo) throws CaixaNaoEncontradaException {
		if(existe(codigo)){
			return caixaMap.get(codigo);
		}else throw new CaixaNaoEncontradaException();
	}

	@Override
	public boolean existe(int codigo) {
		if(caixaMap.containsKey(codigo)){ 
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Caixa> listar() {
		ArrayList<Caixa> lista = new ArrayList<Caixa>();
		Set<Integer> keys = caixaMap.keySet();
		for(Integer key : keys){
			lista.add(caixaMap.get(key));
		}
		return lista;
	}

}
