package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;

public class Caixa {
	
	private	Cliente cliente;
	private	int codigo;
	private String descricao;
	private	Estante estante;
	
	public Caixa(int codigo, String descricao, Estante estante, Cliente cliente){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setEstante(estante);
		this.setCliente(cliente);
	}
	
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public String getDescricao(){
		return descricao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public Estante getEstante(){
		return estante;
	}
	public void setEstante(Estante estante){
		this.estante = estante;
	}
	
	
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public String toString(){
		return "Caixa= "+ "Codigo: "+codigo+ " Descrição"+descricao;
	}
	
}
