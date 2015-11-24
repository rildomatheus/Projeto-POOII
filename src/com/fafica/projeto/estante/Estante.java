package com.fafica.projeto.estante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fafica.projeto.caixa.Caixa;
import com.fafica.projeto.caixa.CaixaJaCadastradaException;
import com.fafica.projeto.funcionario.Funcionario;

public class Estante {
		
		private String rua;
		private int codigo;
		private Caixa caixa;
		private Map<Integer, Caixa> mapCaixas = new HashMap();
		private ArrayList<Caixa> listaCaixas = new ArrayList<Caixa>();
		
		
		public Estante(int codigo, String rua){
			this.setCodigo(codigo);
			this.setRua(rua);
			
		}	
		
		public void setCodigo(int codigo) {this.codigo = codigo;}
		public int getCodigo(){return codigo;}
		
		public void setRua(String rua){this.rua = rua;}
		public String  getRua(){return rua;}
				
		public String toString(){
			return "Código: "+codigo+" | Rua: "+rua;
		}

}
