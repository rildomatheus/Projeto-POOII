package com.fafica.projeto.caixa;

import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.fachada.Fachada;

public class TelaCaixa {

	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();
		Caixa caixa = new Caixa(1,"Pessoa Fisica");
		Caixa caixa2 = new Caixa(2,"Pessoa Juridica");
		try {
			fachada.cadastrarCaixa(caixa);
			fachada.cadastrarCaixa(caixa2);
		} catch (CaixaJaCadastradaException e) {
			System.out.println(e.getMessage());

		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());

		} catch (CampoObritarorioInvalidoException e) {
			System.out.println(e.getMessage());

		}
		System.out.println(fachada.listarCaixa());
	}
}