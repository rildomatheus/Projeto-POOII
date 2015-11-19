package com.fafica.projeto.estante;

import java.util.List;

public interface IRepositorioEstante {
	
	public void cadastrar(Estante estante) throws EstanteJaCadastradaException;
	public void atualizar(Estante stante) throws EstanteNaoEncontradaException;
	public void remover(int codigo) throws EstanteNaoEncontradaException;
	public Estante procurar(int codigo) throws EstanteNaoEncontradaException;
	public boolean existe(int codigo);
	public List<Estante> listar();

}
