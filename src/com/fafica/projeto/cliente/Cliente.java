package com.fafica.projeto.cliente;

public class Cliente {
	
	private int codigo;
	private String nome;
	
		
	 public Cliente(){
		 
	 }
	 
	 public Cliente(int codigo, String nome){
		 this.setCodigo(codigo);
		 this.setNome(nome);
	 }
	 
	 public String toString(){
		 return "Cliente"+ "\nCodigo: "+codigo + "\nNome: "+nome;
	 }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	
}
