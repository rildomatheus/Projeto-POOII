package com.fafica.projeto.administrador;

import java.util.ArrayList;

public interface IRepositorioAdministrador {
	
	public void cadastrar(Administrador adminstrador);
	public void atualizar(Administrador administrador);
	public void remover(int codigo);
	public Administrador procurar(int codigo);
	public boolean existe(int codigo);
	public ArrayList<Administrador>listar();


}