package com.curso.main;

public class ClasePaquete {

	public ClasePaquete() {
		int temporal;
		new MainClass.ClaseStatic();
		MainClass mainClass = new MainClass();
//		Visibilidades no permitidas dentro de la clase, las siguentes lineas generar error:
//		temporal = mainClass.variablePrivate;
		temporal = mainClass.variableDefault;
		temporal = mainClass.variableProtected;
		temporal = mainClass.variablePublic;
		
//		Visibilidades no permitidas dentro de la clase, las siguentes lineas generar error:
//		mainClass.metodoPrivate();
		mainClass.metodoProtected();
		mainClass.metodoDefault();
		mainClass.metodoPublic();
	}

}
