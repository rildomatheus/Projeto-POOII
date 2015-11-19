package com.fafica.projeto.caixa;

import java.util.ArrayList;
import java.util.HashSet;

public class RepositorioCaixaSet implements IRepositorioCaixa{
	HashSet<Caixa> caixaSet;
	
	public RepositorioCaixaSet(){
		caixaSet = new HashSet<Caixa>();
	}
	
	@Override
	public void cadastrar(Caixa caixa) throws CaixaJaCadastradaException {
		if(existe(caixa.getCodigo())) throw new CaixaJaCadastradaException();
		caixaSet.add(caixa);
		System.out.println("Caixa Cadastrado Com Sucesso!!");
	}

	@Override
	public void atualizar(Caixa caixa) throws CaixaNaoEncontradaException {
		if(existe(caixa.getCodigo())){
			Caixa caixaAtualizar = null;
			for(Caixa caixaBuscar : caixaSet){
				if(caixaBuscar.getCodigo() == caixa.getCodigo()){
					caixaAtualizar = caixaBuscar;
				}
			}
			caixaSet.remove(caixaAtualizar);
			caixaSet.add(caixa);
			System.out.println("Caixa Atualizada Com Sucesso!!");
		}else throw new CaixaNaoEncontradaException();
		
	}

	@Override
	public void remover(int codigo) throws CaixaNaoEncontradaException {
		if(existe(codigo)){
			Caixa caixaRemover = null;
			for(Caixa caixaBuscar : caixaSet){
				if(caixaBuscar.getCodigo() == codigo){
					caixaRemover = caixaBuscar;
				}
			
			}
			caixaSet.remove(caixaRemover);
			System.out.println("Caixa Removida Com Sucesso!!");
		} else throw new CaixaNaoEncontradaException();	
		
	}

	@Override
	public Caixa procurar(int codigo) throws CaixaNaoEncontradaException {
		if(!existe(codigo)) throw new CaixaNaoEncontradaException();
		Caixa caixaProcura = null; 
		
		for(Caixa caixaBuscar : caixaSet){
			if(caixaBuscar.getCodigo() == codigo){
				caixaProcura = caixaBuscar;
			}
		}
		return caixaProcura;
	}

	@Override
	public boolean existe(int codigo) {
		for(Caixa caixaBuscar : caixaSet){
			if(caixaBuscar.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Caixa> listar() {
		ArrayList<Caixa> list = new ArrayList<Caixa>();
		for(Caixa caixa : caixaSet){
			list.add(caixa);
		}
		return list;
	}

}
