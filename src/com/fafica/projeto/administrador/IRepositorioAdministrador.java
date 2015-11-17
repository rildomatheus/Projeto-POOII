package com.fafica.projeto.administrador;

import java.util.ArrayList;

public interface IRepositorioAdministrador {
	
	public void cadastrar(Administrador administrador) throws AdministradorJaCadastradoException;
	public void atualizar(Administrador administrador);
	public void remover(int codigo) throws AdministradorNaoEncontradoException;
	public Administrador procurar(int codigo) throws AdministradorNaoEncontradoException;
	public boolean existe(int codigo);
	public ArrayList<Administrador>listar();


}