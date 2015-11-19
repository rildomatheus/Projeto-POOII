package com.fafica.projeto.caixa;

import java.util.ArrayList;



public interface IRepositorioCaixa {
	
	public void cadastrar(Caixa caixa) throws CaixaJaCadastradaException;
	public void atualizar(Caixa caixa) throws CaixaNaoEncontradaException;
	public void remover(int codigo) throws CaixaNaoEncontradaException;
	public Caixa procurar(int codigo) throws CaixaNaoEncontradaException;
	public boolean existe(int codigo) throws CaixaNaoEncontradaException;
	public ArrayList<Caixa> listar();
	
}
