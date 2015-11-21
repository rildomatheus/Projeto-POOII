package com.fafica.projeto.estante;

import java.util.ArrayList;
import java.util.List;

import com.fafica.projeto.caixa.Caixa;

public class Estante {
		
		private String rua;
		private int codigo;
		private int modulos;
		private Caixa caixa;
		private List<Caixa> listaCaixas = new ArrayList<Caixa>();
		
		
		public Estante(int codigo, String rua, int modulos){
			this.setCodigo(codigo);
			this.setRua(rua);
			this.setModulos(modulos);
		}		
		
		public void setCodigo(int codigo) {this.codigo = codigo;}
		public int getCodigo(){return codigo;}
		
		public void setRua(String rua){this.rua = rua;}
		public String  getRua(){return rua;}
		
		public void setModulos(int modulos) {this.modulos = modulos;}
		public int getModulos(){return this.modulos;}
				
		public void setCaixa(Caixa caixa){listaCaixas.add(caixa);}
		public  List<Caixa> getListaCaixa(){return listaCaixas;}
		
		public List<Caixa> listarCaixas(){
			return listaCaixas;
		}
		
		public String toString(){
			return "Código: "+codigo+" | Rua: "+rua+" Módulos: "+modulos;
		}

}
