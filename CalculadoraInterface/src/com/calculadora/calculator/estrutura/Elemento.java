package com.calculadora.calculator.estrutura;

public class Elemento {
	private Elemento proximo;
	private String valor;
	
	public Elemento (String valor) {
		this.valor = valor;
		this.proximo = null;
	}

	public Elemento getProximo() {
		return proximo;
	}

	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
