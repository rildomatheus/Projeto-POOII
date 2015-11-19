package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;

public class Caixa {
	
	private	int codigo;
	private String descricao;

	
	public Caixa(int codigo, String descricao){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		
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
		return "Caixa= "+ "Codigo:"+codigo+ " Descrição:"+descricao;
	}
	
}
