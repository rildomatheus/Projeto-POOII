package com.fafica.projeto.caixa;

public class CaixaJaCadastradaException extends Exception{

		public CaixaJaCadastradaException(){
			super ("Caixa j� Cadastrada!!");
		}
		
		public CaixaJaCadastradaException(String msg){
			super ("Caixa " +msg+ "J� Cadastrada");
		}
}
