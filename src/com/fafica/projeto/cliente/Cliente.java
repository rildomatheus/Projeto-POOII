package com.fafica.projeto.cliente;

public class Cliente {
	
	private int codigo;
	private String nome;
	private int loja;
	
	 public Cliente(String nome, int loja){
		 this.setNome(nome);
		 this.setLoja(loja);
	 }
	 
	public Cliente(int codigo, String nome, int loja){
		 this.setCodigo(codigo);
		 this.setNome(nome);
		 this.setLoja(loja);
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
	
	public int getLoja(){
		return loja;
	}
	public void setLoja(int loja){
		this.loja = loja;
	}
	
	public String toString(){
		return "[Cliente= " + " Codigo:"+codigo + " Nome:"+nome + " Loja:"+loja + "]";
	 }
}