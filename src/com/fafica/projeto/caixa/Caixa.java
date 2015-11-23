package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;

public class Caixa {
	
	private	int codigo;
	private String descricao;
	private Estante estante;
	private Cliente cliente;
	
	public Caixa(int codigo, String descricao){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}
	
	public Caixa(int codigo, String descricao, Cliente cliente, Estante estante){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setCliente(cliente);
		this.setEstante(estante);
	}
	
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	public Cliente getCliente(){
		return this.cliente;
	}
	
	public void setEstante(Estante estante){
		this.estante = estante;
	}
	public Estante getEstante(){
		return this.estante;
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
	
	public String toString(){
		return "CAIXA= "+ "Codigo:"+codigo+ " Descrição:"+descricao+" Cliente: "+ cliente + " Estante: "+estante;
	}
}
