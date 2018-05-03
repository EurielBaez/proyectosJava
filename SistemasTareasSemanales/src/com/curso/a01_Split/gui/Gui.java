package com.curso.a01_Split.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Gui implements ActionListener{
	private JFrame jf = new JFrame("Sistema para division de cadenas");
	private JButton jbEjecutar 	= new JButton("Ejecutar");
	private JPanel  jpTextos	= new JPanel(new GridLayout(2, 1));
	private JPanel  jpAcciones	= new JPanel(new BorderLayout());
	
	private JTextArea jtaEntrada	= new JTextArea();
	private JTextArea jtaSalida		= new JTextArea();
	private JTextArea jtaPattern	= new JTextArea();
	
	private JScrollPane jspEntrada	= new JScrollPane(jtaEntrada);
	private JScrollPane jspSalida	= new JScrollPane(jtaSalida);
	private JScrollPane jspPattern	= new JScrollPane(jtaPattern);
	
	public Gui() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setSize(d.width/4, d.height/4);
		jf.setLocation(d.width/8, d.height/8);
		jtaSalida.setEditable(false);
		jbEjecutar.addActionListener(this);
		
		jspEntrada.setBorder(	new TitledBorder("Entrada"));
		jspPattern.setBorder(	new TitledBorder("Pattern"));
		jspSalida.setBorder(	new TitledBorder("Salida"));
		
		jpTextos.add(jspEntrada);
		jpTextos.add(jspSalida);
		
		jpAcciones.add("Center", jspPattern);
		jpAcciones.add("East", jbEjecutar);
		
		jf.getContentPane().add("Center", jpTextos);
		jf.getContentPane().add("South", jpAcciones);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jtaSalida.setText("");
		if(e.getSource() == jbEjecutar) {
			String [] data = jtaEntrada.getText().split(jtaPattern.getText());
			for (String token : data) {
				jtaSalida.setText(jtaSalida.getText()+((jtaSalida.getText().length()<2)?"":"\n")+"- "+token);
			}
		}
	}
	public static void main(String[] args) {
		new Gui();
	}
}

