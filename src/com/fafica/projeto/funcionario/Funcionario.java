package com.fafica.projeto.funcionario;

public class Funcionario {
	
	private Integer codigo;
	private String nome;

	public Funcionario(Integer codigo, String nome){
		this.setCodigo(codigo);
		this.setNome(nome);		
	}
	
	public void setCodigo(Integer codigo) {this.codigo = codigo;}
	public Integer getCodigo(){return codigo;}

	public void setNome(String nome){this.nome = nome;}
	public String  getNome(){return nome;}

	public String toString(){
		return "Nome: " +nome+ ". Codigo: "+codigo;
	}

}
