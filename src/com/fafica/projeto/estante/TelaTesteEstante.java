package com.fafica.projeto.estante;

import com.fafica.projeto.caixa.Caixa;
import com.fafica.projeto.fachada.Fachada;

public class TelaTesteEstante {
	
	public static void main(String[] args){
		Caixa caixa = new Caixa(1,"Documentos de zezinho");
		
	//	Fachada fachada = Fachada.getInstance();
		Estante estante = new Estante(12,"Rua 3",10);
	//	Estante estante1 = new Estante(13,"Rua 4",10);
	//	Estante estante2 = new Estante(12,"Rua 5",10);
		
		estante.setCaixa(caixa.getCodigo(),caixa);
		estante.setCaixa(caixa.getCodigo(),caixa);
		estante.setCaixa(caixa.getCodigo(),caixa);
		System.out.println(estante);
		/*
		try {
			fachada.cadastrarEstante(estante);
			fachada.cadastrarEstante(estante1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstanteJaCadastradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
		}
		/*
		try {
			fachada.atualizarEstante(estante2);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstanteNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}
		/*
		try {
			fachada.removerEstante(13);
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstanteNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}*/
		/*
		try {
			System.out.println(fachada.procurarEstante(13));
			System.out.println();
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstanteNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}*/
		
	}

}
