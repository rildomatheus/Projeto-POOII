package com.fafica.projeto.estante;

import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;

public class TelaTesteEstante {
	
	public static void main(String[] args){
		
		Fachada fachada = Fachada.getInstance();
		Estante estante = new Estante(12,"Rua 3");
		Estante estante1 = new Estante(13,"Rua 4");
		Estante estante2 = new Estante(12,"Rua 5");
		
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
			System.out.println("ERROR!");
		}
		
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
		
		try {
			fachada.removerEstante(13);
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstanteNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}
		
		try {
			System.out.println(fachada.procurarEstante(12));
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstanteNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}
		
	}

}
