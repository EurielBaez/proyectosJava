package com.curso.a03_Polimorfismo.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Gui implements ActionListener{
	private JPanel  	jpAnimales	= new JPanel(new GridLayout(1,1));
	private JPanel  	jpAcciones	= new JPanel(new GridLayout(1,2));
	
	private JFrame 	jf = new JFrame("Sistema para gestionar polimorfismo");
	private JDialog jdSalida	= new JDialog(jf,"Salida",true);
	private JLabel	jlSalida = new JLabel("");
	
	private String [] opciones = {"Selecciones alguna opcion","Crear Aguila","Crear Gato","Crear Perro","Crear Tortuga"};
	private JComboBox jcbAcciones = new JComboBox(opciones);
	private JButton jbEjecutar 	= new JButton("Ejecutar");
	private List<Animal> animales = new ArrayList<Animal>();
	
	public Gui() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setSize(d.width/4, d.height/3);
		jf.setLocation(d.width/8, d.height/8);
		jbEjecutar.addActionListener(this);

		jdSalida.getContentPane().add("Center", jlSalida);
		
		jpAnimales.setBorder(	new TitledBorder("Animales"));
		jpAcciones.setBorder(	new TitledBorder("Acciones"));
		jpAcciones.add(jcbAcciones);
		jpAcciones.add(jbEjecutar);
		
		jf.getContentPane().add("Center", jpAnimales);
		jf.getContentPane().add("South", jpAcciones);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Animal animal : animales) {
			if(e.getSource() == animal.getBoton()) {
				jlSalida.setText(animal.hablar());
				mostrarDialog();
			}
		}
		if(e.getSource() == jbEjecutar) {
			switch(jcbAcciones.getSelectedIndex()) {
				case 1:{animales.add(this.new Aguila(this));	recalcularGui();};break;
				case 2:{animales.add(this.new Gato(this));		recalcularGui();};break;
				case 3:{animales.add(this.new Perro(this));		recalcularGui();};break;
				case 4:{animales.add(this.new Tortuga(this));	recalcularGui();};break;
				default:{
					jlSalida.setText("Seleccione una opcion");
					mostrarDialog();
				};break;
			}
		}
	}
	private void mostrarDialog() {
		jdSalida.setLocation(jf.getWidth()/4+jf.getLocation().x, jf.getHeight()/4+jf.getLocation().y);
		jdSalida.setSize(jf.getWidth()/2, jf.getHeight()/2);
		jdSalida.setVisible(true);
	}
	
	private void recalcularGui() {
		jf.getContentPane().remove(jpAnimales);
		jpAnimales = new JPanel(new GridLayout((int)(Math.sqrt(animales.size()/2))+1,(int)(Math.sqrt(animales.size()/2))+1));
		for (Animal animal : animales) {
			jpAnimales.add(animal.getBoton());
		}
		jf.getContentPane().add("Center", jpAnimales);
		jf.setVisible(true);
	}
	

	public static void main(String[] args) {
		new Gui();
	}
	
	private String rutaCarpetaImagenes = new File("").getAbsolutePath()+"/src/com/curso/a03_Polimorfismo/source/";
	private interface Animal{
		public JButton getBoton();
		public String hablar();
	}
	private class Aguila implements Animal{
		String rutaImagen = rutaCarpetaImagenes+ "aguila.jpg";
		private JButton boton = new JButton( new ImageIcon(rutaImagen) );
		public Aguila(ActionListener l) {
			boton.addActionListener(l);
			ImageIcon imageIcon = (ImageIcon) boton.getIcon(); 
			Image image = imageIcon.getImage();  
			boton.setIcon(new ImageIcon(image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH)));
		}
		@Override
		public JButton getBoton() {
			return boton;
		}
		@Override
		public String hablar() {
			return "Soy un Aguila";
		}
	}
	private class Gato implements Animal{
		String rutaImagen = rutaCarpetaImagenes+ "gato.jpg";
		private JButton boton = new JButton( new ImageIcon(rutaImagen) );
		public Gato(ActionListener l) {
			boton.addActionListener(l);
			ImageIcon imageIcon = (ImageIcon) boton.getIcon(); 
			Image image = imageIcon.getImage();  
			boton.setIcon(new ImageIcon(image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH)));
		}
		@Override
		public JButton getBoton() {
			return boton;
		}
		@Override
		public String hablar() {
			return "Soy un gato";
		}
	}
	private class Perro implements Animal{
		String rutaImagen = rutaCarpetaImagenes+ "perro.jpg";
		private JButton boton = new JButton( new ImageIcon(rutaImagen) );
		public Perro(ActionListener l) {
			boton.addActionListener(l);
			ImageIcon imageIcon = (ImageIcon) boton.getIcon(); 
			Image image = imageIcon.getImage();  
			boton.setIcon(new ImageIcon(image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH)));
		}
		@Override
		public JButton getBoton() {
			return boton;
		}
		@Override
		public String hablar() {
			return "Soy un perro";
		}
	}
	private class Tortuga implements Animal{
		String rutaImagen = rutaCarpetaImagenes+ "tortuga.jpg";
		private JButton boton = new JButton( new ImageIcon(rutaImagen) );
		public Tortuga(ActionListener l) {
			boton.addActionListener(l);
			ImageIcon imageIcon = (ImageIcon) boton.getIcon(); 
			Image image = imageIcon.getImage();  
			boton.setIcon(new ImageIcon(image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH)));
		}
		@Override
		public JButton getBoton() {
			return boton;
		}
		@Override
		public String hablar() {
			return "Soy una tortuga";
		}
	}
}

