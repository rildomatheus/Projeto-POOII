package com.fafica.projeto.estante;

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

import com.fafica.projeto.caixa.Caixa;
import com.fafica.projeto.cliente.Cliente;

public class RepositorioEstanteIO implements IRepositorioEstante{

	private ArrayList<Estante> estantes;
	private ArrayList<Caixa> caixas;
	Path path = Paths.get("C:/Users/Dennis/git/Projeto-POOII/Files/estantes.txt");
	Path path2 = Paths.get("C:/Users/Dennis/git/Projeto-POOII/Files/caixasNaEstante.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	
	
	public RepositorioEstanteIO(){
		estantes = new ArrayList<Estante>();
		caixas = new ArrayList<Caixa>();
	}
	
	public void armazenarDadosIncremental(Estante estante){
		try(BufferedWriter escritor = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND)){
			escritor.write(estante.getCodigo()+";"+estante.getRua()+";"+"\r\n");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void armazenarDadosArray(ArrayList<Estante> estantes){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Estante estante : estantes){
				escritor.write(estante.getCodigo()+";"+estante.getRua()+";"+"\r\n");
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Estante> recuperarDados(){
		ArrayList<Estante> estanteLidos = new ArrayList<Estante>();
		try(BufferedReader leitor = Files.newBufferedReader(path,utf8)){
			String linha = null;
			while((linha = leitor.readLine()) != null){
				String[] atributo = linha.split(";");
				Estante estante = new Estante(Integer.parseInt(atributo[0]),atributo[1]);
				estanteLidos.add(estante);
			}
		} catch (IOException e){
			System.out.println("Ocorreu um erro");
		}
		return estanteLidos;
	}
	
	public void cadastrar(Estante estante) throws EstanteJaCadastradaException{
		if(existe(estante.getCodigo())) throw new EstanteJaCadastradaException();
		estantes.add(estante);
		armazenarDadosIncremental(estante);
	}
		
	
	
	public void atualizar(Estante estante) throws EstanteNaoEncontradaException{
		if(existe(estante.getCodigo())){
			Estante estanteAtualizar = null;
			for(Estante estanteBusca : estantes){
				if(estanteBusca.getCodigo() == estante.getCodigo()){
					estanteAtualizar = estanteBusca;
				}
			}
			estantes.remove(estanteAtualizar);
			estantes.add(estante);
			armazenarDadosArray(estantes);
			
		}else throw new EstanteNaoEncontradaException();
	}
	
	public void remover(int codigo) throws EstanteNaoEncontradaException{
		if(existe(codigo)){
			Estante estanteRemover = null;
			for(Estante estanteBusca : estantes){
				if(estanteBusca.getCodigo() == codigo){
					estanteRemover = estanteBusca;
				}
			
			}
			estantes.remove(estanteRemover);
			armazenarDadosArray(estantes);
			
		} else throw new EstanteNaoEncontradaException();	
	}
	
	public Estante procurar(int codigo) throws EstanteNaoEncontradaException{
		if(!existe(codigo))throw new EstanteNaoEncontradaException();
		estantes = recuperarDados();
		Estante estanteProcura = null; 
		for(Estante estanteBusca : estantes){
			if(estanteBusca.getCodigo() == codigo){
				estanteProcura = estanteBusca;
			}
		}
		return estanteProcura;
	}	
	

	public boolean existe(int codigo){
		estantes = recuperarDados();
		for(Estante estanteBusca : estantes){
			if(estanteBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
	
	//Lista os funcionários cadastrados	
	public ArrayList<Estante> listar(){
		estantes = recuperarDados();
		
		return estantes;
	}
	


}
