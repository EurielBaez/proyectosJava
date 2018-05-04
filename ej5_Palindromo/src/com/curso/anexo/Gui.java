package com.curso.anexo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Gui implements ActionListener {

	private JFrame jf = new JFrame();
	
	private JButton jbEjecutar 				= new JButton("Ejecutar");
	private JPanel jpTextos 				= new JPanel(new GridLayout(2,2));
	private JPanel jpAcciones 				= new JPanel(new GridLayout(4,1));
	private JCheckBox jcbIgnorarEspacios 	= new JCheckBox("Ignorar Espacios");
	private JCheckBox jcbIgnorarEnters		= new JCheckBox("Ignorar Enters");
	private JCheckBox jcbIgnorarMayus 		= new JCheckBox("Ignorar Mayus y minus");
	private JTextArea jtaEntrada 			= new JTextArea();
	private JTextArea jtaSalida 			= new JTextArea();
	private JScrollPane jspEntrada 			= new JScrollPane(jtaEntrada);
	private JScrollPane jspSalida 			= new JScrollPane(jtaSalida);
	
	public Gui(){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setSize(d.width/4, d.height/3);
		jf.setLocation(d.width/8, d.height/8);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtaSalida.setEditable(false);
		jspEntrada.setBorder(new TitledBorder("Entrada"));
		jspSalida.setBorder(new TitledBorder("Salida"));
		jpAcciones.setBorder(new TitledBorder("Acciones"));
		jpTextos.add(jspEntrada);
		jpTextos.add(jspSalida);
		jpAcciones.add(jcbIgnorarEspacios);
		jpAcciones.add(jcbIgnorarEnters);
		jpAcciones.add(jcbIgnorarMayus);
		jpAcciones.add("Ejecutar",jbEjecutar);		
		jf.getContentPane().add("Center",jpTextos);
		jf.getContentPane().add("East",jpAcciones);
		
//		Asi se indica al boton que tiene que tomar acciones
//		y que esas acciones las maneja this que es la instancia
//		donde se esta trabajando, recuerda que ya sacamos el listener
//		y lo asociamos a otra clase y esa la instanciamos y se la pasamos al 
//		component, al final queda asi:
		jbEjecutar.addActionListener(this);
		
//		esto que pusiste esta super mal
//		recuerda que a quien se le va a pasar la formula de manejar eventos
//		es al boton no a el que contiene el Jframe
//		this.actionPerformed(jbEjecutar);
		jf.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cadena = jtaEntrada.getText();
		String resultado = "Al verificar la cadena "+"\""+cadena+"\"";
		if(e.getSource()==jbEjecutar){
			if (jcbIgnorarEspacios.isSelected()) {
//				en este punto vas bien
				cadena=cadena.replace(" ", "");
//				pero recuerda que en la salida indica la directiva que se ha asignado
//				correctamente entonces solo faltaria:
				resultado+="\n - Con la directiva de Ignorar Espacios";
			}
			if (jcbIgnorarEnters.isSelected()) {
//				Aca hay que hacer exactamente lo mismo que en la de espacios pero con 
				cadena=cadena.replace("\n", "");
//				asi vas a cambiar los enters por vacio
//				cadena=cadena.
				resultado+="\n - Con la directiva de Ignorar Enteros";
			}
			if (jcbIgnorarMayus.isSelected()) {
				cadena=cadena.toLowerCase();
				resultado+="\n - Con la directiva de Ignorar Mayusculas";
			}
			char[] c = cadena.toCharArray();
			boolean palindromo = true;
			for (int i = 0; i < c.length/2; i++) {
				if (c[i]!=c[c.length-i-1]) {
					palindromo = false;
					break;
				}
			}
//			MAL!!!!
//			if (palindromo=true) {
//			ESTA Linea esta dando valor a la variable palindromo de true
//			como es booleana al final ve palindromo y siempre va a ser true
//			si quieres comparar una cadena con true es (palindromo==true) y no (palindromo=true)
//			este es un erro fuerte
			
			if (palindromo==true) {
//				Super mal.... ya habiamos hablado victor, hay que entender como concatenar
//				por que aca estas reescribiendo lo mismo a una variable que ya tenia esos datos
//				y no esta cubierto el caso que no sea un palindromo, mucho cuidado
				
				resultado += "\nque SI es un palindromo";
			} else {
				resultado += "\nque NO es un palindromo";
			}
			jtaSalida.setText(resultado);
		}		
	}	
}
