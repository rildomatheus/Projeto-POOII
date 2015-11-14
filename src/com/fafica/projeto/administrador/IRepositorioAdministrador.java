package com.fafica.projeto.administrador;

import java.util.ArrayList;

public interface IRepositorioAdministrador {
	
	public void cadastradar(Administrador adminstrador);
	public void atualizar(Administrador administrador);
	public boolean remover(Integer codigo);
	public Administrador procurar(Integer codigo);
	public boolean existe(Integer codigo);
	public ArrayList<Administrador>listar();


}
