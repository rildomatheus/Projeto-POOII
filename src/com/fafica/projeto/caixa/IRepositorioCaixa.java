package com.fafica.projeto.caixa;

import java.util.ArrayList;



public interface IRepositorioCaixa {
	
	public void cadastrar(Caixa caixa);
	public void atualizar(Caixa caixa);
	public void remover(int codigo) throws CaixaNaoEncontradoException;
	public Caixa procurar(int codigo) throws CaixaNaoEncontradoException;
	public Caixa procurarCliente(int codigo) ;
	public Caixa procurarEstante(int codigo);
	public boolean existe(int codigo);
	public ArrayList<Caixa> listar();
	
}
