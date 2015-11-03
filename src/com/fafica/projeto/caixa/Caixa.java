package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.documento.Documento;

public class Caixa {
	
	private	Integer codigo;
	private	Cliente cliente;
	private	Estante estante;
	private Documento documento;
	
	public Caixa(){
		
	}
	
	public Caixa(Integer codigo, Cliente Cliente, Estante estante,Documento documento){
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setEstante(estante);
		this.setDocumento(documento);
	}
	
	public Integer getCodigo(){
		return codigo;
	}
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
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
	
	public Documento getDocumento(){
		return documento;
	}
	public void setDocumento(Documento documento){
		this.documento = documento;
	}
	
	public String toString(){
		return "Caixa "+ "\nCodigo: "+codigo+ "\nCliente: "+cliente+ "Estante: "+estante+ "\nDocumento: "+documento;
	}
	
}
