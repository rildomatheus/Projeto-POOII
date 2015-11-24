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

import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;

public class RepositorioCaixaIo implements IRepositorioCaixa{
	
	Path path = Paths.get("C:/Users/Dennis/git/Projeto-POOII/Files/caixas.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	private ArrayList<Caixa> arrayListCaixa;
	
	public RepositorioCaixaIo(){
		arrayListCaixa = new ArrayList<Caixa>();
	}
	
	public void armazenarDadosIncremental(Caixa caixa){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8, StandardOpenOption.APPEND)){
			escritor.write(caixa.getCodigo()+";"+caixa.getDescricao()+";"+caixa.getCliente().getCodigo()+";"+caixa.getCliente().getNome()
					+";"+caixa.getCliente().getLoja()+";"+caixa.getEstante().getCodigo()+";"+caixa.getEstante().getRua()+"\r\n");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void armazenarDadosArray(ArrayList<Caixa> arrayListCaixa){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Caixa caixa : arrayListCaixa){
				escritor.write(caixa.getCodigo()+";"+caixa.getDescricao()+";"+caixa.getCliente().getCodigo()+";"+caixa.getCliente().getNome()
						+";"+caixa.getCliente().getLoja()+";"+caixa.getEstante().getCodigo()+";"+caixa.getEstante().getRua()+"\r\n");
			}
		} catch (IOException e){
			System.out.println("ERROR");
		}
	}
	
	public ArrayList<Caixa> recuperarDados(){
		ArrayList<Caixa> caixaLida = new ArrayList<Caixa>();
		try(BufferedReader leitor = Files.newBufferedReader(path,utf8)){
			String linha = null;
			while((linha = leitor.readLine()) != null){
				String[] atributo = linha.split(";");
				Cliente cliente = new Cliente(Integer.parseInt(atributo[2]),atributo[3],Integer.parseInt(atributo[4]));
				Estante estante = new Estante(Integer.parseInt(atributo[5]),atributo[6]);
				Caixa caixa = new Caixa(Integer.parseInt(atributo[0]),atributo[1],cliente,estante);
				caixaLida.add(caixa);
			}
		} catch (IOException e){
			System.out.println("ERROR");
		}
		return caixaLida;
	}
	
	public void cadastrar(Caixa caixa) throws CaixaJaCadastradaException{
		if(existe(caixa.getCodigo())) throw new CaixaJaCadastradaException();
		armazenarDadosIncremental(caixa);
		
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