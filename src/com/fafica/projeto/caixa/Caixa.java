package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;

public class Caixa {
	
	private	int codigo;
	private String descricao;
	private Cliente cliente;
	private Estante estante;
	
	public Caixa(int codigo, String descricao, Cliente cliente, Estante estante){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setCliente(cliente);
		this.setEstante(estante);
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
	
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public Estante getEstante(){
		return estante;
	}
	public void setEstante(Estante estante){
		this.estante = estante;
	}
	
	public String toString(){
		return "CAIXA= "+ "Codigo:"+codigo+ " Descrição:"+descricao+" "+cliente+ " Estante= "+estante;
	}
	
}
