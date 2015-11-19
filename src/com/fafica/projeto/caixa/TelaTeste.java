package com.fafica.projeto.caixa;

import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {
	
	public static void main(String[] args){
	
		Fachada fachada =  Fachada.getInstance();
		Caixa caixa = new Caixa(1,"Pessoa Juridica");
		Caixa caixa2 = new Caixa(1,"sei la");
		
		try {
			fachada.cadastrarCaixa(caixa);
		} catch (CaixaJaCadastradaException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fachada.cadastrarCaixa(caixa2);
		} catch (CaixaJaCadastradaException e) {
			System.out.println(e.getMessage());

		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());

		}
		
		System.out.println(fachada.listarCaixa());
	}
}
