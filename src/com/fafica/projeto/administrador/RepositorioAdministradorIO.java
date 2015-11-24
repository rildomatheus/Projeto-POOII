package com.fafica.projeto.administrador;

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

public class RepositorioAdministradorIO implements IRepositorioAdministrador{
	Path path = Paths.get("C:/Users/Lynneker/git/Projeto-POOII/Files/administradores.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	private ArrayList<Administrador> listaAdministrador;
	
	
	public RepositorioAdministradorIO(){
		listaAdministrador = new ArrayList<Administrador>();
		
	}
	
	public void armazenarDadosIncremental(Administrador administrador){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8, StandardOpenOption.APPEND)){
			escritor.write(administrador.getCodigo()+";"+administrador.getNome()+"\r\n");
		} catch (IOException e){
		//	System.out.println("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	public void armazenarDadosArray(ArrayList<Administrador> listaAdministrador){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Administrador administrador : listaAdministrador){
				escritor.write(administrador.getCodigo()+";"+administrador.getNome()+"\r\n");
			}
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
	}
	
	public ArrayList<Administrador> recuperarDados(){
		ArrayList<Administrador> administradoresLidos = new ArrayList<Administrador>();
		try(BufferedReader leitor = Files.newBufferedReader(path,utf8)){
			String linha = null;
			while((linha = leitor.readLine()) != null){
				String[] atributo = linha.split(";");
				Administrador administrador = new Administrador(Integer.parseInt(atributo[0]),atributo[1]);
				administradoresLidos.add(administrador);
			}
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
		return administradoresLidos;
	}
	
	public void cadastrar(Administrador administrador) throws AdministradorJaCadastradoException{
		if(existe(administrador.getCodigo())) throw new AdministradorJaCadastradoException();
		armazenarDadosIncremental(administrador);
		
	}
	
	public void atualizar(Administrador administrador) throws AdministradorNaoEncontradoException{
		listaAdministrador = recuperarDados();
		if(existe(administrador.getCodigo())){
			Administrador administradorAtualizar = null;
			for(Administrador administradorBusca : listaAdministrador){
				if(administradorBusca.getCodigo() == administrador.getCodigo()){
					administradorAtualizar = administradorBusca;
				}
			}
			listaAdministrador.remove(administradorAtualizar);
			listaAdministrador.add(administrador);
			armazenarDadosArray(listaAdministrador);
		
		}else throw new AdministradorNaoEncontradoException();
	}
	
	

	
	public void remover(int codigo) throws AdministradorNaoEncontradoException {
		listaAdministrador = recuperarDados();
		if(existe(codigo)){
			Administrador administradorRemover = null;
			for(Administrador administradorBusca : listaAdministrador){
				if(administradorBusca.getCodigo() == codigo){
					administradorRemover = administradorBusca;
				}
			
			}
			listaAdministrador.remove(administradorRemover);
			armazenarDadosArray(listaAdministrador);
		
		} else throw new AdministradorNaoEncontradoException();	
	}
		
	

	public Administrador procurar(int codigo) throws AdministradorNaoEncontradoException {
		if(!existe(codigo))throw new AdministradorNaoEncontradoException();
		listaAdministrador = recuperarDados();
		Administrador administradorProcura = null; 
		for(Administrador administradorBusca : listaAdministrador){
			if(administradorBusca.getCodigo() == codigo){
				administradorProcura = administradorBusca;
			}
		}
		return administradorProcura;
	}
	public boolean existe(int codigo){
		listaAdministrador = recuperarDados();
		for(Administrador administradorBusca : listaAdministrador){
			if(administradorBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Administrador> listar(){
		listaAdministrador = recuperarDados();
		return listaAdministrador;
		
}
}
