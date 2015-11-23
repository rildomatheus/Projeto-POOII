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
		private int modulos;
		private Caixa caixa;
		private Map<Integer, Caixa> mapCaixas = new HashMap();
		
		
		public Estante(int codigo, String rua, int modulos){
			this.setCodigo(codigo);
			this.setRua(rua);
			this.setModulos(modulos);
		}	
		public Estante(int codigo, String rua, int modulos, Caixa caixa){
			this.setCodigo(codigo);
			this.setCodigo(codigo);
			this.setRua(rua);
			this.setModulos(modulos);
			this.setCaixa(caixa.getCodigo(), caixa);
		}
		
		public void setCodigo(int codigo) {this.codigo = codigo;}
		public int getCodigo(){return codigo;}
		
		public void setRua(String rua){this.rua = rua;}
		public String  getRua(){return rua;}
		
		public void setModulos(int modulos) {this.modulos = modulos;}
		public int getModulos(){return this.modulos;}
				
		public void setCaixa(Integer codigo, Caixa caixa){
			if(mapCaixas.containsKey(codigo)){String msg = "Caixa já cadastrada!";}
			if(mapCaixas.size() < modulos){String msg = "Estante lotada";}
			mapCaixas.put(codigo,caixa);
			
			}
		
		public ArrayList<Caixa> getListaCaixa(){
			ArrayList<Caixa> lista = new ArrayList<Caixa>();
			Set<Integer> keys = mapCaixas.keySet();
			for(Integer key : keys){
				lista.add(mapCaixas.get(key));
			}
			return lista;
		}
		
		public String toString(){
			return "Código: "+codigo+" | Rua: "+rua+" Módulos: "+modulos+" Caixas cadastradas: "+getListaCaixa();
		}

}
