package com.fafica.projeto.caixa;

import java.util.ArrayList;

public class RepositorioCaixaMap implements IRepositorioCaixa {

	@Override
	public void cadastrar(Caixa caixa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Caixa caixa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int codigo) throws CaixaNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caixa procurar(int codigo) throws CaixaNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caixa procurarCliente(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caixa procurarEstante(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Caixa> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
