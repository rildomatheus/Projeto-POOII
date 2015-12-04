package com.fafica.projeto.funcionario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class RepositorioFuncionarioIO implements IRepositorioFuncionario{
	
	private Path path = Paths.get("C:/Users/Dennis/git/Projeto-POOII/Files/funcionarios.txt");
	private Charset utf8 = StandardCharsets.UTF_8;
	private ArrayList<Funcionario> funcionarios;
	private File arquivo;
	
	public RepositorioFuncionarioIO(){
		funcionarios = new ArrayList<Funcionario>();
		arquivo = new File("C:/Users/Dennis/git/Projeto-POOII/Files/funcionarios.txt");
	}
	
	public void armazenarDadosIncremental(Funcionario funcionario){
		if(!arquivo.exists()){
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8, StandardOpenOption.APPEND)){
			escritor.write(funcionario.getCodigo()+";"+funcionario.getNome()+"\r\n");
		} catch (IOException e){
		//	System.out.println("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	public void armazenarDadosArray(ArrayList<Funcionario> funcionarios){
		if(!arquivo.exists()){
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Funcionario funcionario : funcionarios){
				escritor.write(funcionario.getCodigo()+";"+funcionario.getNome()+"\r\n");
			}
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
	}
	
	public ArrayList<Funcionario> recuperarDados(){
		ArrayList<Funcionario> funcionariosLidos = new ArrayList<Funcionario>();
		try(BufferedReader leitor = Files.newBufferedReader(path,utf8)){
			String linha = null;
			while((linha = leitor.readLine()) != null){
				String[] atributo = linha.split(";");
				Funcionario funcionario = new Funcionario(Integer.parseInt(atributo[0]),atributo[1]);
				funcionariosLidos.add(funcionario);
			}
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
		return funcionariosLidos;
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if(existe(funcionario.getCodigo())) throw new FuncionarioJaCadastradoException();
		armazenarDadosIncremental(funcionario);
		//funcionarios.add(funcionario);
	//	armazenarDadosArray(funcionarios);
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		funcionarios = recuperarDados();
		if(existe(funcionario.getCodigo())){
			Funcionario funcionarioAtualizar = null;
			for(Funcionario funcionarioBusca : funcionarios){
				if(funcionarioBusca.getCodigo() == funcionario.getCodigo()){
					funcionarioAtualizar = funcionarioBusca;
				}
			}
			funcionarios.remove(funcionarioAtualizar);
			funcionarios.add(funcionario);
			armazenarDadosArray(funcionarios);
		
		}else throw new FuncionarioNaoEncontradoException();
	}
	
	

	
	public void remover(int codigo) throws FuncionarioNaoEncontradoException {
		funcionarios = recuperarDados();
		if(existe(codigo)){
			Funcionario funcionarioRemover = null;
			for(Funcionario funcionarioBusca : funcionarios){
				if(funcionarioBusca.getCodigo() == codigo){
					funcionarioRemover = funcionarioBusca;
				}
			
			}
			funcionarios.remove(funcionarioRemover);
			armazenarDadosArray(funcionarios);
		
		} else throw new FuncionarioNaoEncontradoException();	
	}
		
	

	public Funcionario procurar(int codigo) throws FuncionarioNaoEncontradoException {
		if(!existe(codigo))throw new FuncionarioNaoEncontradoException();
		funcionarios = recuperarDados();
		Funcionario funcionarioProcura = null; 
		for(Funcionario funcionarioBusca : funcionarios){
			if(funcionarioBusca.getCodigo() == codigo){
				funcionarioProcura = funcionarioBusca;
			}
		}
		return funcionarioProcura;
	}
	public boolean existe(int codigo){
		funcionarios = recuperarDados();
		for(Funcionario funcionarioBusca : funcionarios){
			if(funcionarioBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Funcionario> listar(){
		funcionarios = recuperarDados();
		return funcionarios;
		
	}
		
}
