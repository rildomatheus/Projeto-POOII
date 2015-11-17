package com.fafica.projeto.funcionario;

public class Funcionario {
	
	protected int codigo;
	protected String nome;
	protected int id;

	public Funcionario(int codigo, String nome){
		this.setCodigo(codigo);
		this.setNome(nome);		
	}
	
	
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public int getCodigo(){return codigo;}
	
	public void setNome(String nome){this.nome = nome;}
	public String  getNome(){return nome;}

	public String toString(){
		return "Nome: " +nome+ " | Codigo: "+codigo+" |\n";
	}

}
