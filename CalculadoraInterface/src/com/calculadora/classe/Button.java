package com.calculadora.classe;
import javax.swing.JButton;
public class Button {
	private JButton button;
	private String valor;
	private boolean isNumber;
	private boolean decimal;
	public Button (JButton button) {
		this.button = button;
		String text = button.getText();
		if (text.chars().allMatch(Character::isDigit)) {
			this.isNumber = true;
			this.decimal = false;

		}
		else if(text.equals("+")|| text.equals("-")||text.equals("x")||text.equals("/") || text.equals("<x|") || text.equals("(") || text.equals(")") || text.equals("^")) {
			this.isNumber = false;
			this.decimal = false;
		}
		else if(text.equals(".")) {
			this.isNumber= false;
			this.decimal = true;
		}
		this.valor = text;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public boolean isNumber() {
		return isNumber;
	}
	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}
	public boolean isDecimal() {
		return decimal;
	}
	public void setDecimal(boolean decimal) {
		this.decimal = decimal;
	}
	
	
}
