package com.calculadora.calculator;

import java.util.StringTokenizer;
import com.calculadora.calculator.estrutura.*;
public class Calculator {
	public String expression (String expressao) {
		String newEntrada = expressao.replace(" ", "");
		Pilha operadores = new Pilha();
		Pilha saida = new Pilha();
		StringTokenizer tokenizer = new StringTokenizer(newEntrada,"+-*/^()",true);
		while (tokenizer.hasMoreTokens()) {
			String valor = tokenizer.nextToken();
			if(!isOperator(valor)) {
				saida.push(valor);
			}
			else {
				if(valor.equals("(")) {
					operadores.push(valor);
				}
				else if(valor.equals(")")) {
					while(!operadores.topo().equals("(")) {
						saida.push(operadores.pop());
					}
						operadores.pop();
				}
				else {
					if(!operadores.isEmpty()) {
						while(compararPrioridade(valor , operadores.topo())) {
							saida.push(operadores.pop());
						}
					}
					operadores.push(valor);
				}
			}
		}
		while(!operadores.isEmpty()) {
			saida.push(operadores.pop());
		}
		Pilha posFixa = new Pilha();
		while(!saida.isEmpty()) {
			posFixa.push(saida.pop());
		}
		Pilha calculo = new Pilha();
		while(!posFixa.isEmpty()) {
			String valor = posFixa.pop();
			if(!isOperator(valor)) {
				calculo.push(valor);
			}
			else {
				double valor1 = Double.parseDouble(calculo.pop());
				double valor2 =  Double.parseDouble(calculo.pop());
				double valor3 = realizarCalculo(valor , valor1, valor2);
				String resultado = Double.toString(valor3);
				calculo.push(resultado);
			}
		}
		String resultado = calculo.pop();
		return resultado;
	}
	
	public static boolean isOperator (String valor) {
		if (valor.equals("+") || valor.equals("-") || valor.equals("*") || valor.equals("/") || valor.equals("(") || valor.equals(")") || valor.equals("^")) {
			return true;
		}
		return false;
	}
	public static int prioridade (String valor) {
		if(valor.equals("+") || valor.equals("-")) {
			return 1;
		}
		else if (valor.equals("*") || valor.equals("/")) {
			return 2;
		}
		else if (valor.equals("^")) {
			return 3;
		}
		return 0;
		
	}
	public static boolean compararPrioridade (String valor , String topoPilha) {
		if(topoPilha != null) {
			if(!topoPilha.equals("(")) {
				int prioridadeValor = prioridade(valor);
				int prioridadeTopoPilha = prioridade(topoPilha);
				if(prioridadeValor <= prioridadeTopoPilha) {
					return true;
				}
			}
		}
		return false;
	}
	public static double realizarCalculo (String operador, double valor1 , double valor2) {
		switch (operador) {
		case "+":
			return valor2 + valor1;
		case "-":
			return valor2 - valor1;
		case "*": 
			return valor2 * valor1;
		case "/":
			return valor2 / valor1;
		case "^":
			long valor = potenciacao(valor2 , valor1);
			return valor;
		}
		return 0;
	}
	
	public static long potenciacao (double base , double expoente) {
		if(expoente ==0) {
			return 1;
		}
		else {
			return (long) (base*potenciacao(base , --expoente));
		}
	}
	
}
