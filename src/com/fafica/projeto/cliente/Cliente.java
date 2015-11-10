package com.fafica.projeto.cliente;

public class Cliente {
	
	private Integer codigo;
	private String nome;
	private Integer loja;
	
	
	 public Cliente(String nome, Integer loja){
		 this.setNome(nome);
		 this.setLoja(loja);
	 }
	 
	public Cliente(Integer codigo, String nome, Integer loja){
		 this.setCodigo(codigo);
		 this.setNome(nome);
		 this.setLoja(loja);
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
	
	public Integer getLoja(){
		return loja;
	}
	public void setLoja(Integer loja){
		this.loja = loja;
	}
	
	public String toString(){
		return "[Cliente= " + " Codigo:"+codigo + " Nome:"+nome + " Loja:"+loja + "]";
	 }

	public void add(Cliente cliente) {
			
	}
}