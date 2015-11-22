package com.fafica.projeto.caixa;

import java.util.ArrayList;

import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
import com.fafica.projeto.cliente.ControladorCliente;

public class ControladorCaixa {

	private IRepositorioCaixa	repositorioCaixa;
	
	public ControladorCaixa(){
		this.repositorioCaixa = new RepositorioCaixaIo();
	}
	
	public void cadastrar(Caixa caixa) throws  CampoObrigatorioInvalidoException, CaixaJaCadastradaException{
		
		if(caixa.getCodigo() <=0) throw new CampoObrigatorioInvalidoException(" Codigo ");
		if(caixa.getDescricao() == null) throw new CampoObrigatorioInvalidoException(" Descrição ");
		if(caixa.getDescricao().equals(" ")) throw new CampoObrigatorioInvalidoException(" Descrição ");
		//Cadastrar Caixa
		repositorioCaixa.cadastrar(caixa);
	}
	
	public void atualizar(Caixa caixa) throws CaixaNaoEncontradaException{
		repositorioCaixa.atualizar(caixa);
	}
	
	public void remover(int codigo) throws CaixaNaoEncontradaException{
		repositorioCaixa.remover(codigo);
	}
	
	public Caixa procurar(int codigo) throws CaixaNaoEncontradaException {
		if(codigo == codigo){
			return repositorioCaixa.procurar(codigo);
			}else{
				throw new CaixaNaoEncontradaException();
			}
	}
	
	public boolean existe(int codigo) throws CaixaNaoEncontradaException{
		return repositorioCaixa.existe(codigo);
	}
	
	public ArrayList<Caixa> listar(){
		return repositorioCaixa.listar();
	}
	
}
