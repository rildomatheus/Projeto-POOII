package com.fafica.projeto.cliente;

import com.fafica.projeto.documento.Documento;

public class Cliente {
	
	private Integer codigo;
	private String cpf;
	private String nome;
	private Documento documento;
	
		
	 public Cliente(){
		 
	 }
	 
	 public Cliente(int codigo, String nome, String cpf, Documento documento){
		 this.setCodigo(codigo);
		 this.setCPF(cpf);
		 this.setNome(nome);
		 this.setDocumento(documento);
	 }

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getCPF(){
		return cpf;
	}
	public void setCPF(String cpf){
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Documento getDocumento(){
		return documento;
	}
	public void setDocumento(Documento documento){
		this.documento = documento;
	}
	
	
	
	 public String toString(){
		 return "Cliente"+ "\nCodigo: "+codigo + "\nNome: "+nome+ "\nDocumento"+documento;
	 }
}
