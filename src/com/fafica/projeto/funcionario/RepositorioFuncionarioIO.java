package com.fafica.projeto.funcionario;

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
import java.util.List;

public class RepositorioFuncionarioIO implements IRepositorioFuncionario{
	
	Path path = Paths.get("C:/Users/Dennis/git/Projeto-POOII/Files/funcionarios.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	private List<Funcionario> funcionarios;
	
	
	public RepositorioFuncionarioIO(){
		funcionarios = new ArrayList<Funcionario>();
		
	}
	
	public void armazenarDadosIncremental(Funcionario funcionario){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8, StandardOpenOption.APPEND)){
			escritor.write(funcionario.getCodigo()+";"+funcionario.getNome()+"\r\n");
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
	}
	public void armazenarDadosArray(List<Funcionario> funcionarios){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Funcionario funcionario : funcionarios){
				escritor.write(funcionario.getCodigo()+";"+funcionario.getNome()+"\r\n");
			}
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
	}
	
	public List<Funcionario> recuperarDados(){
		List<Funcionario> funcionariosLidos = new ArrayList<Funcionario>();
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
		System.out.println("Funcionário cadastrado com sucesso!");
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
			System.out.println("Funcionário atualizado com sucesso!");
		}else throw new FuncionarioNaoEncontradoException();
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

	@Override
	public void remover(int codigo) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario procurar(int codigo) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
