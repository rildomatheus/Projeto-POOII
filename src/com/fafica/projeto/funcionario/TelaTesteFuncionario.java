package com.fafica.projeto.funcionario;

import com.fafica.projeto.fachada.Fachada;

public class TelaTesteFuncionario {
	
	public static void main(String[] args){
		Funcionario funcionario = new Funcionario(123, "Dennis");
		Funcionario funcionario1 = new Funcionario(4126, "Mike Wazowski");
		Funcionario funcionario2 = new Funcionario(4125, "Zezinho");
		Funcionario funcionario3 = new Funcionario(4123, "Sheriff Woody");
		Fachada fachada = Fachada.getInstance();
		/*
		try {
			fachada.cadastrarFuncionario(funcionario);
			
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}
		
		/*
		try {
			fachada.atualizarFuncionario(funcionario3);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (FuncionarioNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		/*
		try {
			fachada.removerFuncionario(4123);
		} catch (FuncionarioNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		}
		/*
		try{
			System.out.println(fachada.procurarFuncionario(4123));
		} catch (FuncionarioNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (CampoObrigatorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR!");
		} */
		
			System.out.println(fachada.listarFuncionario());
	
	}

}
