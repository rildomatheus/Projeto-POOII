package com.fafica.projeto.cliente;

import com.fafica.projeto.documento.Documento;
import com.fafica.projeto.administrador.Administrador;

public class Cliente {
	
	private Integer codigo;
	private String nome;
	
	public Cliente(){
	
	} 
	
	 public Cliente(Integer codigo, String nome){
		 this.setCodigo(codigo);
		 this.setNome(nome);
	 }

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	 public String toString(){
		 return "Cliente"+ "\nCodigo: "+codigo + "\nNome: "+nome;
	 }
}
