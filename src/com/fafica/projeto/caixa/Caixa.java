package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.documento.Documento;

public class Caixa {
	
	private	Integer codigo;
	private	Estante estante;
	private Documento documento;
	private	Cliente cliente;
	
	public Caixa(){
		
	}
	
	public Caixa(Integer codigo, Estante estante,Documento documento, Cliente cliente){
		this.setCodigo(codigo);
		this.setEstante(estante);
		this.setDocumento(documento);
		this.setCliente(cliente);
	}
	
	public Integer getCodigo(){
		return codigo;
	}
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
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
	
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public String toString(){
		return "Caixa "+ "\nCodigo: "+codigo+ "Estante: "+estante+ "\nDocumento: "+documento+ "Cliente"+cliente;
	}
	
}
