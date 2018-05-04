package com.curso.main;

public class ClasePaqueteHeredado extends MainClass {

	public ClasePaqueteHeredado() {
		int temporal;
//		Visibilidades no permitidas dentro de la clase, las siguentes lineas generar error:
//		temporal = this.variablePrivate;
		temporal = this.variableDefault;
		temporal = this.variableProtected;
		temporal = this.variablePublic;
		
//		Visibilidades no permitidas dentro de la clase, las siguentes lineas generar error:
//		this.metodoPrivate();
		this.metodoProtected();
		this.metodoDefault();
		this.metodoPublic();
	}

}
