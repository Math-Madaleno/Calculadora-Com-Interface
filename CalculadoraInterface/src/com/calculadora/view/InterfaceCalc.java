package com.calculadora.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.calculadora.controler.*;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.calculadora.classe.*;
import java.awt.Dialog.ModalExclusionType;
public class InterfaceCalc {

	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button soma;
	private Button subtracao;
	private Button multiplicacao;
	private Button divisao;
	private Button potenciacao;
	private Button decimal;
	private Button actionResult;
	private Button clean;
	private Button backspace;
	private Button parenteses;
	private JFrame frmCalculadora;
	private JTextField inputExpressao;
	private boolean flag = false;
	private static int maxTamanho =27;
	private int tamanho=0;
	
	public void setFlag (boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag () {
		return this.flag;
	}
	public int getMaxTamanho () {
		return this.maxTamanho;
	}
	public int getTamanho () {
		return this.tamanho;
	}
	public void setTamanho (int tamanho) {
		this.tamanho = tamanho;
	}
	

	/**
	 * Launch the application.
	 */
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCalc window = new InterfaceCalc();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmCalculadora.setAlwaysOnTop(true);
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setBackground(Color.BLACK);
		frmCalculadora.setBackground(Color.BLACK);
		frmCalculadora.setResizable(false);
		frmCalculadora.setForeground(Color.BLACK);
		frmCalculadora.setFont(null);
		frmCalculadora.getContentPane().setEnabled(false);
		frmCalculadora.setBounds(600, 150, 370, 410);
		frmCalculadora.getContentPane().setLayout(null);
		
		inputExpressao = new JTextField();
		inputExpressao.setForeground(Color.BLACK);
		inputExpressao.setHorizontalAlignment(SwingConstants.RIGHT);
		inputExpressao.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		inputExpressao.setText("0");
		inputExpressao.setBackground(Color.WHITE);
		inputExpressao.setEditable(false);
		inputExpressao.setBounds(10, 11, 332, 54);
		frmCalculadora.getContentPane().add(inputExpressao);
		inputExpressao.setColumns(10);
		
		JButton btnNumber_0 = new JButton("0");
		btnNumber_0.setForeground(Color.BLACK);
		btnNumber_0.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_0.setBackground(Color.WHITE);
		btnNumber_0.setBounds(94, 304, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_0);
		button0 = new Button(btnNumber_0);
		btnNumber_0.addActionListener(new Controler(this, button0));
		
		JButton btnNumber_1 = new JButton("1");
		btnNumber_1.setForeground(Color.BLACK);
		btnNumber_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_1.setBackground(Color.WHITE);
		btnNumber_1.setBounds(10, 250, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_1);
		button1 = new Button(btnNumber_1);
		btnNumber_1.addActionListener(new Controler(this, button1));
		
		JButton btnNumber_2 = new JButton("2");
		btnNumber_2.setForeground(Color.BLACK);
		btnNumber_2.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_2.setBackground(Color.WHITE);
		btnNumber_2.setBounds(94, 250, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_2);
		button2 = new Button(btnNumber_2);
		btnNumber_2.addActionListener(new Controler(this, button2));
		
		JButton btnNumber_3 = new JButton("3");
		btnNumber_3.setForeground(Color.BLACK);
		btnNumber_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_3.setBackground(Color.WHITE);
		btnNumber_3.setBounds(178, 250, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_3);
		button3 = new Button(btnNumber_3);
		btnNumber_3.addActionListener(new Controler(this, button3));
		
		JButton btnNumber_4 = new JButton("4");
		btnNumber_4.setForeground(Color.BLACK);
		btnNumber_4.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_4.setBackground(Color.WHITE);
		btnNumber_4.setBounds(10, 195, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_4);
		button4 = new Button(btnNumber_4);
		btnNumber_4.addActionListener(new Controler(this, button4));
		
		JButton btnNumber_5 = new JButton("5");
		btnNumber_5.setForeground(Color.BLACK);
		btnNumber_5.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_5.setBackground(Color.WHITE);
		btnNumber_5.setBounds(94, 195, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_5);
		button5 = new Button(btnNumber_5);
		btnNumber_5.addActionListener(new Controler(this, button5));
		
		JButton btnNumber_6 = new JButton("6");
		btnNumber_6.setForeground(Color.BLACK);
		btnNumber_6.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_6.setBackground(Color.WHITE);
		btnNumber_6.setBounds(178, 195, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_6);
		button6 = new Button(btnNumber_6);
		btnNumber_6.addActionListener(new Controler(this, button6));
		
		JButton btnNumber_7 = new JButton("7");
		btnNumber_7.setForeground(Color.BLACK);
		btnNumber_7.setBackground(Color.WHITE);
		btnNumber_7.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_7.setBounds(10, 142, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_7);
		button7 = new Button(btnNumber_7);
		btnNumber_7.addActionListener(new Controler(this, button7));
		
		JButton btnNumber_8 = new JButton("8");
		btnNumber_8.setForeground(Color.BLACK);
		btnNumber_8.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_8.setBackground(Color.WHITE);
		btnNumber_8.setBounds(94, 142, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_8);
		button8 = new Button(btnNumber_8);
		btnNumber_8.addActionListener(new Controler(this, button8));

		JButton btnNumber_9 = new JButton("9");
		btnNumber_9.setForeground(Color.BLACK);
		btnNumber_9.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNumber_9.setBackground(Color.WHITE);
		btnNumber_9.setBounds(178, 142, 80, 50);
		frmCalculadora.getContentPane().add(btnNumber_9);
		button9 = new Button(btnNumber_9);
		btnNumber_9.addActionListener(new Controler(this, button9));

		JButton btnClean = new JButton("C");
		btnClean.setForeground(Color.BLACK);
		btnClean.setFont(new Font("Georgia", Font.PLAIN, 30));
		btnClean.setBackground(Color.WHITE);
		btnClean.setBounds(10, 85, 80, 50);
		frmCalculadora.getContentPane().add(btnClean);
		clean = new Button(btnClean);
		btnClean.addActionListener(new Controler(this, clean));
		
		JButton btnActionResult = new JButton("=");
		btnActionResult.setForeground(Color.BLACK);
		btnActionResult.setFont(new Font("Georgia", Font.PLAIN, 40));
		btnActionResult.setBackground(Color.WHITE);
		btnActionResult.setBounds(262, 304, 80, 50);
		frmCalculadora.getContentPane().add(btnActionResult);
		actionResult = new Button(btnActionResult);
		btnActionResult.addActionListener(new Controler(this, actionResult));
		
		JButton btnButtonSoma = new JButton("+");
		btnButtonSoma.setForeground(Color.BLACK);
		btnButtonSoma.setFont(new Font("Georgia", Font.PLAIN, 30));
		btnButtonSoma.setBackground(Color.WHITE);
		btnButtonSoma.setBounds(262, 250, 80, 50);
		frmCalculadora.getContentPane().add(btnButtonSoma);
		soma = new Button(btnButtonSoma);
		btnButtonSoma.addActionListener(new Controler(this, soma));
		
		JButton btnButtonSub = new JButton("-");
		btnButtonSub.setForeground(Color.BLACK);
		btnButtonSub.setFont(new Font("Georgia", Font.PLAIN, 30));
		btnButtonSub.setBackground(Color.WHITE);
		btnButtonSub.setBounds(262, 195, 80, 50);
		frmCalculadora.getContentPane().add(btnButtonSub);
		subtracao = new Button(btnButtonSub);
		btnButtonSub.addActionListener(new Controler(this, subtracao));
		
		JButton btnButtonMulti = new JButton("x");
		btnButtonMulti.setForeground(Color.BLACK);
		btnButtonMulti.setFont(new Font("Georgia", Font.PLAIN, 30));
		btnButtonMulti.setBackground(Color.WHITE);
		btnButtonMulti.setBounds(262, 142, 80, 50);
		frmCalculadora.getContentPane().add(btnButtonMulti);
		multiplicacao = new Button(btnButtonMulti);
		btnButtonMulti.addActionListener(new Controler(this, multiplicacao));
		
		JButton btnButtonDiv = new JButton("/");
		btnButtonDiv.setForeground(Color.BLACK);
		btnButtonDiv.setFont(new Font("Georgia", Font.PLAIN, 25));
		btnButtonDiv.setBackground(Color.WHITE);
		btnButtonDiv.setBounds(178, 85, 80, 50);
		frmCalculadora.getContentPane().add(btnButtonDiv);
		divisao = new Button(btnButtonDiv);
		btnButtonDiv.addActionListener(new Controler(this, divisao));
		
		JButton btnParenteses = new JButton("( )");
		btnParenteses.setForeground(Color.BLACK);
		btnParenteses.setFont(new Font("Georgia", Font.PLAIN, 25));
		btnParenteses.setBackground(Color.WHITE);
		btnParenteses.setBounds(94, 85, 80, 50);
		frmCalculadora.getContentPane().add(btnParenteses);
		parenteses = new Button(btnParenteses);
		btnParenteses.addActionListener(new Controler(this, parenteses));
		
		
		JButton btnBackspace = new JButton("<x|");
		btnBackspace.setForeground(Color.BLACK);
		btnBackspace.setFont(new Font("Georgia", Font.PLAIN, 30));
		btnBackspace.setBackground(Color.WHITE);
		btnBackspace.setBounds(262, 85, 80, 50);
		frmCalculadora.getContentPane().add(btnBackspace);
		backspace = new Button(btnBackspace);
		btnBackspace.addActionListener(new Controler(this, backspace));
		
		JButton btnVirgula = new JButton(".");
		btnVirgula.setForeground(Color.BLACK);
		btnVirgula.setFont(new Font("Georgia", Font.PLAIN, 35));
		btnVirgula.setBackground(Color.WHITE);
		btnVirgula.setBounds(10, 304, 80, 50);
		frmCalculadora.getContentPane().add(btnVirgula);
		decimal = new Button(btnVirgula);
		btnVirgula.addActionListener(new Controler(this, decimal));
		
		JButton btnButtonPotenciacao = new JButton("^");
		btnButtonPotenciacao.setForeground(Color.BLACK);
		btnButtonPotenciacao.setFont(new Font("Georgia", Font.PLAIN, 30));
		btnButtonPotenciacao.setBackground(Color.WHITE);
		btnButtonPotenciacao.setBounds(178, 304, 80, 50);
		frmCalculadora.getContentPane().add(btnButtonPotenciacao);
		potenciacao = new Button(btnButtonPotenciacao);
		btnButtonPotenciacao.addActionListener(new Controler(this, potenciacao));
		
		
		
	}

	public JFrame getFrmCalculadora() {
		return frmCalculadora;
	}

	public void setFrmCalculadora(JFrame frmCalculadora) {
		this.frmCalculadora = frmCalculadora;
	}

	public JTextField getInputExpressao() {
		return inputExpressao;
	}

	public void setInputExpressao(JTextField inputExpressao) {
		this.inputExpressao = inputExpressao;
	}
}
