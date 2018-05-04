package com.curso.complemento;

import com.curso.main.MainClass;

public class ClaseExternaHeredado extends MainClass {

	public ClaseExternaHeredado() {
		int temporal;
//		Visibilidades no permitidas dentro de la clase, las siguentes lineas generar error:
//		temporal = this.variablePrivate;
//		temporal = this.variableDefault;
		temporal = this.variableProtected;
		temporal = this.variablePublic;
//		this.metodoPrivate();
		this.metodoProtected();
//		this.metodoDefault();
		this.metodoPublic();
	}

}
