package com.fafica.projeto.estante;

import java.util.ArrayList;
import java.util.List;

import com.fafica.projeto.caixa.Caixa;

public class Estante {
		
		private String rua;
		private int codigo;
		private Caixa caixa;
		private List<Caixa> listaCaixas;
		
		
		public Estante(int codigo, String rua, Caixa caixa){
			this.setCodigo(codigo);
			this.setRua(rua);
			listaCaixas = new ArrayList<Caixa>();
			this.setCaixa(caixa);
			
		}
		
		public Estante(int codigo, String rua){
			this.setCodigo(codigo);
			this.setRua(rua);
		}
		
		public void setCodigo(int codigo) {this.codigo = codigo;}
		public int getCodigo(){return codigo;}
		
		public void setRua(String rua){this.rua = rua;}
		public String  getRua(){return rua;}
		
		public void setCaixa(Caixa caixa){listaCaixas.add(caixa);}
		public Caixa getCaixa(){return this.caixa;}
		
		public List<Caixa> listarCaixas(){
			return listaCaixas;
		}
		
		public String toString(){
			return "Código: "+codigo+" | Rua: "+rua;
		}

}
