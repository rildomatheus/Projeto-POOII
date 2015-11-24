package com.fafica.projeto.cliente;

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

public class RepositorioClienteIo implements IRepositorioCliente{
	
	Path path = Paths.get("C:/Users/Dennis/git/Projeto-POOII/Files/clientes.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	private ArrayList<Cliente> arrayListCliente;
	
	public RepositorioClienteIo(){
		arrayListCliente = new ArrayList<Cliente>();
	}
	
	public void armazenarDadosIncremental(Cliente cliente){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8, StandardOpenOption.APPEND)){
			escritor.write(cliente.getCodigo()+";"+cliente.getNome()+";"+cliente.getLoja()+"\r\n");
		} catch (IOException e){
			System.out.println("ERROR");
		}
	}
	
	public void armazenarDadosArray(ArrayList<Cliente> arrayListCliente){
		try(BufferedWriter escritor = Files.newBufferedWriter(path,utf8)){
			for(Cliente cliente : arrayListCliente){
				escritor.write(cliente.getCodigo()+";"+cliente.getNome()+";"+cliente.getLoja()+"\r\n");
			}
		} catch (IOException e){
			System.out.println("ERROR");
		}
	}
	
	public ArrayList<Cliente> recuperarDados(){
		ArrayList<Cliente> clienteLidos = new ArrayList<Cliente>();
		try(BufferedReader leitor = Files.newBufferedReader(path,utf8)){
			String linha = null;
			while((linha = leitor.readLine()) != null){
				String[] atributo = linha.split(";");
				Cliente cliente = new Cliente(Integer.parseInt(atributo[0]),atributo[1],Integer.parseInt(atributo[2]));
				clienteLidos.add(cliente);
			}
		} catch (IOException e){
			System.out.println("ERROR");
		}
		return clienteLidos;
	}
	

	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if(existe(cliente.getCodigo())) throw new ClienteJaCadastradoException();
		armazenarDadosIncremental(cliente);
	//	System.out.println("Cliente cadastrado com sucesso!");
	}
	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		arrayListCliente = recuperarDados();
		if(existe(cliente.getCodigo())){
			Cliente clienteAtualizar = null;
			for(Cliente clienteBusca : arrayListCliente){
				if(clienteBusca.getCodigo() == cliente.getCodigo()){
					clienteAtualizar = clienteBusca;
				}
			}
			arrayListCliente.remove(clienteAtualizar);
			arrayListCliente.add(cliente);
			armazenarDadosArray(arrayListCliente);
		//	System.out.println("Cliente Atualizado Com Sucesso!");
		}else throw new ClienteNaoEncontradoException();
	}

	@Override
	public void remover(int codigo) throws ClienteNaoEncontradoException {
		arrayListCliente = recuperarDados();
		if(existe(codigo)){
			Cliente clienteRemover = null;
			for(Cliente clienteBusca : arrayListCliente){
				if(clienteBusca.getCodigo() == codigo){
					clienteRemover = clienteBusca;
				}
			
			}
			arrayListCliente.remove(clienteRemover);
			armazenarDadosArray(arrayListCliente);
		//	System.out.println("Cliente Removido Com Sucesso!");
		} else throw new ClienteNaoEncontradoException();	
	}

	@Override
	public Cliente procurar(int codigo) throws ClienteNaoEncontradoException {
		if(!existe(codigo))throw new ClienteNaoEncontradoException();
		arrayListCliente = recuperarDados();
		Cliente clienteProcura = null; 
		for(Cliente clienteBusca : arrayListCliente){
			if(clienteBusca.getCodigo() == codigo){
				clienteProcura = clienteBusca;
			}
		}
		return clienteProcura;
	}

	@Override
	public boolean existe(int codigo) {
		arrayListCliente = recuperarDados();
		for(Cliente clienteBusca : arrayListCliente){
			if(clienteBusca.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		arrayListCliente = recuperarDados();
		return arrayListCliente;
		
	}
}