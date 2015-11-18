package com.fafica.projeto.caixa;

public class ControladorCaixa {

	private IRepositorioCaixa	repositorioCaixa;
	
	public ControladorCaixa(){
		this.repositorioCaixa = new RepositorioCaixaArrayList();
	}
}
