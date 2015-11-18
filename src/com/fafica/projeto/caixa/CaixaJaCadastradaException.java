package com.fafica.projeto.caixa;

public class CaixaJaCadastradaException extends Exception{

		public CaixaJaCadastradaException(){
			super ("Caixa já Cadastrada!!");
		}
		
		public CaixaJaCadastradaException(String msg){
			super ("Caixa " +msg+ "Já Cadastrada");
		}
}
