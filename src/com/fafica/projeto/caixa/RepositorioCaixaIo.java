package com.fafica.projeto.caixa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class RepositorioCaixaIo implements IRepositorioCaixa{
	
	Path path = Paths.get("C:/Users/Lynneker/git/Projeto-POOII/Files/caixas.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	private ArrayList<Caixa> arrayListCaixa;
	
	public RepositorioCaixaIo(){
		arrayListCaixa = new ArrayList<Caixa>();
	}
	
	public void armazenarDadosIncremental(Caixa caixa){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8, StandardOpenOption.APPEND)){
			escritor.write(caixa.getCodigo()+";"+caixa.getDescricao()+"\r\n");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void armazenarDadosArray(ArrayList<Caixa> arrayListCaixa){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Caixa caixa : arrayListCaixa){
				escritor.write(caixa.getCodigo()+";"+caixa.getDescricao()+"\r\n");
			}
		} catch (IOException e){
			System.out.println("ERROR");
		}
	}
	
	public ArrayList<Caixa> recuperarDados(){
		ArrayList<Caixa> caixaLidos = new ArrayList<Caixa>();
		try(BufferedReader leitor = Files.newBufferedReader(path,utf8)){
			String linha = null;
			while((linha = leitor.readLine()) != null){
				String[] atributo = linha.split(";");
				Caixa caixa = new Caixa(Integer.parseInt(atributo[0]),atributo[1]);
				caixaLidos.add(caixa);
			}
		} catch (IOException e){
			System.out.println("ERROR");
		}
		return caixaLidos;
	}
	
	public void cadastrar(Caixa caixa) throws CaixaJaCadastradaException{
		if(existe(caixa.getCodigo())) throw new CaixaJaCadastradaException();
		armazenarDadosIncremental(caixa);
		System.out.println("Caixa cadastrada com sucesso!");
	}
		
	public void atualizar(Caixa caixa) throws CaixaNaoEncontradaException{
		arrayListCaixa = recuperarDados();
		if(existe(caixa.getCodigo())){
			Caixa caixaAtualizar = null;
			for(Caixa caixaBusca : arrayListCaixa){
				if(caixaBusca.getCodigo() == caixa.getCodigo()){
					caixaAtualizar = caixaBusca;
				}
			}
			arrayListCaixa.remove(caixaAtualizar);
			arrayListCaixa.add(caixa);
			armazenarDadosArray(arrayListCaixa);
			System.out.println("Caixa Atualizado Com Sucesso!");
		}else throw new CaixaNaoEncontradaException();
	}
	
	public void remover(int codigo) throws CaixaNaoEncontradaException{
		arrayListCaixa = recuperarDados();
		if(existe(codigo)){
			Caixa caixaRemover = null;
			for(Caixa caixaBusca : arrayListCaixa){
				if(caixaBusca.getCodigo() == codigo){
					caixaRemover = caixaBusca;
				}		
			}
			arrayListCaixa.remove(caixaRemover);
			armazenarDadosArray(arrayListCaixa);
			System.out.println("Caixa Removido Com Sucesso!");
		} else throw new CaixaNaoEncontradaException();	
	}
	
	public Caixa procurar(int codigo) throws CaixaNaoEncontradaException{
		if(!existe(codigo))throw new CaixaNaoEncontradaException();
		arrayListCaixa = recuperarDados();
		Caixa caixaProcura = null; 
		for(Caixa caixaBusca : arrayListCaixa){
			if(caixaBusca.getCodigo() == codigo){
				caixaProcura = caixaBusca;
			}
		}
		return caixaProcura;
	}
	
	public boolean existe(int codigo){
		arrayListCaixa = recuperarDados();
		for(Caixa caixaBusca : arrayListCaixa){
			if(caixaBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	//Lista os funcionários cadastrados	
	public ArrayList<Caixa> listar(){
		arrayListCaixa = recuperarDados();
		return arrayListCaixa;
	}
}