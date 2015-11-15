package com.fafica.projeto.administrador;

import com.fafica.projeto.funcionario.Funcionario;

public class Administrador extends Funcionario{

	public Administrador(Integer codigo, String nome) {
		super(codigo, nome);
		
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

	public void setNome(String nome){
		
		this.nome = nome;
	}
	
	public String toString() {
		return "Administrador [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	

}

