package com.fafica.projeto.documento;

import com.fafica.projeto.caixa.Caixa;
import com.fafica.projeto.cliente.Cliente;

public class Documento {
	
	private Integer codigo;
	private String nome;
	private String descricao;
	private Cliente cliente;
	private Caixa caixa;
	
	public Documento(Integer codigo, String nome, String descricao, Cliente cliente, Caixa caixa){
		
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setCliente(cliente);
		this.setCaixa(caixa);
	}

	
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
	}
	public Integer getCodigo(){
		return codigo;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}	
	public String getDescricao(){
		return descricao;
	}


	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	public Cliente getCliente(){
		return cliente;
	}

	public void setCaixa(Caixa caixa){
		this.caixa = caixa;
	}
	public Caixa getCaixa(){
		return caixa;
	}
	
	public String toString(){
		return "Codigo: "+ codigo+" Nome: "+nome+" Descricao: "+descricao+" Cliente: "+cliente+" Caixa: "+caixa;

	}

}
