package com.fafica.projeto.cliente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class RepositorioClienteIo  {

	public static void main(String[] args) throws IOException{
	Path path = Paths.get("C:/Users/Lynneker/git/Projeto-POOII/Files/clientes.txt");
	
	byte[] bytes = "Meu Texto".getBytes();
	Files.write(path, bytes);
	
	}
}