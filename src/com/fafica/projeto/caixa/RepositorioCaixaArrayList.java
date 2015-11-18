package com.fafica.projeto.caixa;

import java.util.ArrayList;

import com.fafica.projeto.cliente.Cliente;


public class RepositorioCaixaArrayList implements IRepositorioCaixa{
	ArrayList<Caixa> arrayListCaixa;
	
	public  RepositorioCaixaArrayList(){
		arrayListCaixa = new ArrayList<Caixa>();
	}
	
	@Override
	public void cadastrar(Caixa caixa) {
		arrayListCaixa.add(caixa);
	}

	@Override
	public void atualizar(Caixa caixa) {
		for(Caixa atualizarCaixas : arrayListCaixa){
			if(atualizarCaixas.getCodigo() == caixa.getCodigo()){
				arrayListCaixa.remove(atualizarCaixas);
				arrayListCaixa.add(caixa);
			}
		}
		
	}

	@Override
	public void remover(int codigo) throws CaixaNaoEncontradoException{
		if(existe(codigo)){
			Caixa caixaRemover = null;
			for(Caixa caixaBusca : arrayListCaixa){
				if(caixaBusca.getCodigo() == codigo){
					caixaRemover = caixaBusca;
				}
			
			}
			arrayListCaixa.remove(caixaRemover);
			System.out.println("Cliente removido com sucesso!");
		} else throw new CaixaNaoEncontradoException();	
	}
	

	@Override
	public Caixa procurar(int codigo) throws CaixaNaoEncontradoException{
		if(!existe(codigo))throw new CaixaNaoEncontradoException();
		for(Caixa procurarCaixa : arrayListCaixa){
			if(procurarCaixa.getCodigo() == codigo){
				return procurarCaixa;
			}
		}
		throw new CaixaNaoEncontradoException();
	}
	

	@Override
	public Caixa procurarCliente(int codigo)  {
		return null;
	}

	@Override
	public Caixa procurarEstante(int codigo) {
		// TODO Auto-generated method stub
		return null;
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
