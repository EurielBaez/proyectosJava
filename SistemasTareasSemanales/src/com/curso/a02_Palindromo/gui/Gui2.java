package com.curso.a02_Palindromo.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Gui implements ActionListener{
	private JFrame 		jf = new JFrame("Sistema para verificar palíndromo");
	private JButton 	jbEjecutar 	= new JButton("Ejecutar");
	private JPanel  	jpTextos	= new JPanel(new GridLayout(2,2));
	private JPanel  	jpAcciones	= new JPanel(new GridLayout(4,1));
	private JCheckBox 	jcbIgnorarEspacios 	= new JCheckBox("Ignorar Espacios");
	private JCheckBox 	jcbIgnorarEnters	= new JCheckBox("Ignorar Enters");
	private JCheckBox 	jcbIgnorarMayus 	= new JCheckBox("Ignorar Mayus y minus");
	
	private JTextArea jtaEntrada	= new JTextArea();
	private JTextArea jtaSalida		= new JTextArea();
	
	private JScrollPane jspEntrada	= new JScrollPane(jtaEntrada);
	private JScrollPane jspSalida	= new JScrollPane(jtaSalida);
	
	public Gui() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setSize(d.width/4, d.height/3);
		jf.setLocation(d.width/8, d.height/8);
		jtaSalida.setEditable(false);
		jbEjecutar.addActionListener(this);
		
		jspEntrada.setBorder(	new TitledBorder("Entrada"));
		jspSalida.setBorder(	new TitledBorder("Salida"));
		
		jpTextos.add(jspEntrada);
		jpTextos.add(jspSalida);
		
		jpAcciones.setBorder(	new TitledBorder("Acciones"));
		jpAcciones.add(jcbIgnorarEspacios);
		jpAcciones.add(jcbIgnorarEnters);
		jpAcciones.add(jcbIgnorarMayus);
		jpAcciones.add(jbEjecutar);
		
		jf.getContentPane().add("Center", jpTextos);
		jf.getContentPane().add("East", jpAcciones);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbEjecutar) {
			String cadena = jtaEntrada.getText();
			String resultado = "Al verificar la cadena "+"\""+cadena+"\" ";
			
			if(jcbIgnorarMayus.isSelected()) {
				cadena = cadena.toUpperCase();
				resultado+="\n - Ignorando Mayusculas y minusculas";
			}
			if(jcbIgnorarEnters.isSelected()) {
				cadena = cadena.replaceAll("\n", "");
				cadena = cadena.replaceAll("\r", "");
				resultado+="\n - Ignorando Saltos de linea";
			}
			if(jcbIgnorarEspacios.isSelected()) {
				cadena = cadena.replaceAll(" ", "");
				resultado+="\n - Ignorando espacios";
			}
			char [] c = cadena.toCharArray();
			boolean palindromo = true;
			for (int i = 0; i < c.length/2; i++) {
				if(c[i]!=c[c.length-i-1]) {
					palindromo = false;
				}
			}
			if (palindromo) {
				resultado+="\nVemos que SI es un palindromo";
			} else {
				resultado+="\nVemos que NO es un palindromo";
			}
			jtaSalida.setText(resultado);
		}
	}
	
	public static void main(String[] args) {
		new Gui();
	}
}

