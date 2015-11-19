package com.fafica.projeto.caixa;

import java.util.ArrayList;

public class RepositorioCaixaArrayList implements IRepositorioCaixa{
	ArrayList<Caixa> arrayListCaixa;
	
	public  RepositorioCaixaArrayList(){
		arrayListCaixa = new ArrayList<Caixa>();
	}
	
	@Override
	public void cadastrar(Caixa caixa) throws CaixaJaCadastradaException{
		if(existe(caixa.getCodigo())) throw new CaixaJaCadastradaException();
		arrayListCaixa.add(caixa);
	}

	@Override
	public void atualizar(Caixa caixa) throws CaixaNaoEncontradaException {
		for(Caixa atualizarCaixas : arrayListCaixa){
			if(atualizarCaixas.getCodigo() == caixa.getCodigo()){
				arrayListCaixa.remove(atualizarCaixas);
				arrayListCaixa.add(caixa);
			}
		}
		
	}

	@Override
	public void remover(int codigo) throws CaixaNaoEncontradaException {
		if(existe(codigo)){
			Caixa caixaRemover = null;
			for(Caixa caixaBusca : arrayListCaixa){
				if(caixaBusca.getCodigo() == codigo){
					caixaRemover = caixaBusca;
				}
			
			}
			arrayListCaixa.remove(caixaRemover) ;
			System.out.println("Caixa removido com sucesso!");
		} else throw new CaixaNaoEncontradaException();	
	}
	

	@Override
	public Caixa procurar(int codigo) throws CaixaNaoEncontradaException{
		if(!existe(codigo))throw new CaixaNaoEncontradaException();
		for(Caixa procurarCaixa : arrayListCaixa){
			if(procurarCaixa.getCodigo() == codigo){
				return procurarCaixa;
			}
		}
		throw new CaixaNaoEncontradaException();
	}
	

	@Override
	public boolean existe(int codigo) {
		for(Caixa caixa : arrayListCaixa){
			if(codigo == caixa.getCodigo()){
				return true;
			}
		}
		return false;
	}
	

	@Override
	public ArrayList<Caixa> listar() {
		return arrayListCaixa;
	}

}
