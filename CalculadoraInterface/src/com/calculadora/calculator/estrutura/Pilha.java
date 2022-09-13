package com.calculadora.calculator.estrutura;

public class Pilha {
	private Elemento primeiro;
	
	public Pilha () {
		this.primeiro = new Elemento(null);
	}
	public boolean isEmpty () {
		return primeiro.getProximo() == null;
	}
	public void push(String valor) {
		Elemento novoElemento = new Elemento(valor);
		novoElemento.setProximo(primeiro.getProximo());
		primeiro.setProximo(novoElemento);
	}
	public String pop () {
		if(!isEmpty()) {
			Elemento elementoRetirado = primeiro.getProximo();
			primeiro.setProximo(elementoRetirado.getProximo());
			String valorRetirado = elementoRetirado.getValor();
			elementoRetirado = null;
			return valorRetirado;
		}
		return null;
	}
	public String topo () {
		if(!isEmpty()) {
			Elemento elementoTopo = primeiro.getProximo();
			String valorTopo = elementoTopo.getValor();
			return valorTopo;
		}
		return null;
	}
	public String mostrarPilha() {
		StringBuilder txt = new StringBuilder();
		Elemento aux = primeiro.getProximo();
		while(aux != null) {
			txt.append(aux.getValor());
			aux = aux.getProximo();
		}
		return txt.toString();
	}
	
}
