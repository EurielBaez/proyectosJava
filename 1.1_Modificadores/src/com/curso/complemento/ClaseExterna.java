package com.curso.complemento;

import com.curso.main.MainClass;

public class ClaseExterna {

	public ClaseExterna() {
		int temporal;
		MainClass mainClass = new MainClass();
//		Visibilidades no permitidas dentro de la clase, las siguentes lineas generar error:
//		temporal = mainClass.variablePrivate;
//		temporal = mainClass.variableDefault;
//		temporal = mainClass.variableProtected;
		temporal = mainClass.variablePublic;
//		mainClass.metodoPrivate();
//		mainClass.metodoProtected();
//		mainClass.metodoDefault();
		mainClass.metodoPublic();
	}

}
