package com.calculadora.controler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.calculadora.view.*;
import com.calculadora.classe.*;
import com.calculadora.calculator.*;
public class Controler implements ActionListener{

private InterfaceCalc context;
private Button button;
private boolean flag = false;

	public Controler(InterfaceCalc context, Button button) {
		this.context = context;
		this.button = button;
	}
	public void actionPerformed(ActionEvent e) {
		if(button.isNumber()) {
			numeros();
		}
		else if (!button.isNumber() && !button.isDecimal()) {
			operadores();
		}
		else {
			decimal();
		}
	}
	
	private void numeros () {
		String textoAntigo = context.getInputExpressao().getText();
		String novoTexto = "";
		char c = textoAntigo.charAt(textoAntigo.length()-1);
		int tamanhoAtual = context.getTamanho();
		int maxTamanho = context.getMaxTamanho();
		if(tamanhoAtual < maxTamanho) {
			if(c != ')') {
				if(textoAntigo.equals("0")) {
					context.getInputExpressao().setText(button.getValor());
				}
				else {
					novoTexto =  textoAntigo + button.getValor();
					context.getInputExpressao().setText(novoTexto);
				}
			}
			context.setTamanho(tamanhoAtual+1);
		}
		else {
			JOptionPane alerta = new JOptionPane() ;
			alerta.setForeground(Color.WHITE);
			alerta.setBackground(Color.BLACK);
			alerta.showMessageDialog(null, "Calculadora Atingiu o Limite de Caracteres", "Limite Alcançado",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void operadores () {
		String valor = button.getValor();
		String expressao = context.getInputExpressao().getText();
		int tamanhoAtual = context.getTamanho();
		int maxTamanho = context.getMaxTamanho();
		char lastCaracter = expressao.charAt(expressao.length()-1);
		String novaExpressao ="";
		switch (valor) {
		case "<x|":
			if(expressao.length() == 1) {
				context.getInputExpressao().setText("0");
			}
			else if (expressao.length() > 1) {
				
				for(int i =0; i < expressao.length()-1; ++i) {
					novaExpressao+= expressao.charAt(i);
				}
				context.getInputExpressao().setText(novaExpressao);
				if(lastCaracter == '.') {
					context.setFlag(false);
				}
				context.setTamanho(tamanhoAtual -1);
			}
			
		break;
		case "( )":
			if(tamanhoAtual < maxTamanho) {
				if(!expressao.equals("0")) {
					System.out.println("Sim");
					int abreParenteses =0;
					int fechaParenteses =0;
					for(int i =0; i < expressao.length(); ++i) {
						if(expressao.charAt(i) == '(') {
							abreParenteses++;
						}
						else if(expressao.charAt(i) == ')') {
							fechaParenteses++;
						}
					}
					if(abreParenteses == fechaParenteses) {
						
						char c = expressao.charAt(expressao.length()-1);
						if(!isOperator(c) && c!= '.') {
							novaExpressao = context.getInputExpressao().getText() + "x(";
							context.getInputExpressao().setText(novaExpressao);
							context.setTamanho(tamanhoAtual+2);
						}
						
						else {
						
							novaExpressao = context.getInputExpressao().getText() + "(";
							context.getInputExpressao().setText(novaExpressao);
							context.setTamanho(tamanhoAtual+1);
						}
						
					}
					
					else {
						char c = expressao.charAt(expressao.length()-1);
						if(c != '(' && !isOperator(c)) {
							novaExpressao =  expressao + ")";
							context.getInputExpressao().setText(novaExpressao);
							context.setTamanho(tamanhoAtual+1);
						}
						
					}
					
				}
				else {
					context.getInputExpressao().setText("(");
					context.setTamanho(tamanhoAtual+1);
				}
			}
			else {
				JOptionPane alerta = new JOptionPane() ;
				alerta.setForeground(Color.BLACK);
				alerta.setBackground(Color.WHITE);
				alerta.showMessageDialog(null, "Calculadora Atingiu o Limite de Caracteres", "Limite Alcançado",  JOptionPane.INFORMATION_MESSAGE);
			}
		break;
		case "C":
			if(expressao.length()>=1) {
				context.getInputExpressao().setText("0");
				context.setFlag(false);
				context.setTamanho(0);
			}
		break;
		case "=":
			try {
				if(!expressao.equals("0")) {
					char c = expressao.charAt(expressao.length()-1);
					if(!isOperator(c) && c != '(') {
						Calculator calc = new Calculator();
						String newExpressao = expressao.replace("x" , "*");
						String resultado = calc.expression(newExpressao);
						context.getInputExpressao().setText(resultado);
						context.setFlag(true);
						context.setTamanho(resultado.length());
					}
				}
			}
			catch (StackOverflowError Exception) {
				JOptionPane alerta = new JOptionPane() ;
				alerta.setForeground(Color.BLACK);
				alerta.setBackground(Color.WHITE);
				alerta.showMessageDialog(null, "O Resultado do Calculo pedido Excede os valores permitidos da Calculadora", "Valor Alto demais",  JOptionPane.INFORMATION_MESSAGE);
				
			}

		break;
		default:
			if(!expressao.equals("0")) {
				if(tamanhoAtual < maxTamanho) {
					char c = expressao.charAt(expressao.length()-1);
					if (!isOperator(c) && c !='(' && c !='.') {
						String novoTexto = expressao + valor;
						context.getInputExpressao().setText(novoTexto);
						context.setFlag(false);
						context.setTamanho(tamanhoAtual+1);
					}
				}
				else {
					JOptionPane alerta = new JOptionPane() ;
					alerta.setForeground(Color.BLACK);
					alerta.setBackground(Color.WHITE);
					alerta.showMessageDialog(null, "Calculadora Atingiu o Limite de Caracteres", "Limite Alcançado",  JOptionPane.INFORMATION_MESSAGE);
				}
			}
		break;
		}
	}
	private void decimal () {
		String textoAntigo = context.getInputExpressao().getText();
		char c = textoAntigo.charAt(textoAntigo.length()-1);
		int tamanhoAtual = context.getTamanho();
		int maxTamanho = context.getMaxTamanho();
		boolean flag = context.getFlag();
		if(tamanhoAtual < maxTamanho) {
			if(flag == false) {
				if(!isOperator(c) && c !='(' && c != ')') {
					context.getInputExpressao().setText(textoAntigo + ".");
					context.setFlag(true);
					context.setTamanho(tamanhoAtual+1);
				}
			}
		}
		else {
			JOptionPane alerta = new JOptionPane() ;
			alerta.setForeground(Color.BLACK);
			alerta.setBackground(Color.WHITE);
			alerta.showMessageDialog(null, "Calculadora Atingiu o Limite de Caracteres", "Limite Alcançado",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private boolean isOperator (char c) {
		if(c == '+' || c == '-' || c== 'x' || c=='/' || c =='^') {
			return true;
		}
		return false;
	}
	
}
