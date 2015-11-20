package com.fafica.projeto.caixa;

import java.util.ArrayList;

import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
import com.fafica.projeto.cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.fachada.Fachada;

public class TelaTeste {
	
	public static void main(String[] args){
	
		Fachada fachada =  Fachada.getInstance();	
		
		Cliente cliente = new Cliente(1,"Bonanza",1);
		
		Estante estante = new Estante(12,"Rua 3");
		
		Caixa caixa = new Caixa(1,"Pessoa Fisica",cliente,estante);
		
		
		try {
			fachada.cadastrarCliente(cliente);
			
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CampoObritarorioInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fachada.cadastrarCaixa(caixa);
		} catch (CaixaJaCadastradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CampoObrigatorioInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CampoObritarorioInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		System.out.println(fachada.listarCaixa());
	}
}
