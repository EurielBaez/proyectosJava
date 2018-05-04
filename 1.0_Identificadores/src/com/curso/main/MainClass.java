//++++Formato de las lineas iniciales de los ficheros .java
//	-La primer linea que no sea comentario de cualquier archivo java debe de ser el package 
package com.curso.main;

//	-Las lineas consecutivas que no sean comentarios despues del package de cualquier clase son los imports si es que los hay
import java.awt.Component;

import com.curso.complemento.MiClaseEventListener;
import com.curso.complemento.MiEvento;

//C:\\Users\\user\\Documents\\mike\\proyectos compu\\WorkspaceOriginal2
//	-La clase principal que no es contenedora puede tener solo 2 modificadores de acceso que son public o default

//Palabras reservadas:
//	abstract	boolean	break	byte case	catch	char	class	const	continue	default	do	double
//	else	extends	false	final	finally	float	for	 goto	if	implements	import	instanceof
//	int	interface	long	native	new		null	package	private		protected	public	return	short
//	satatic	super	switch	synchronized	this	throw	transient	true	try	void	volatile	while
	
public class MainClass {
	public static void main(String[] args) {
//++++Los metodos, variables o cualquier identificador se tienen las siguentes restricciones y caracterizticas posibles:
	//-Debe de empezar con cualquier letra mayuscula o minuscula o con el signo '$' o con '_'
	//-Puede contener cualquier letra mayuscula o minuscula o numero o signo '$' o '_'
	//-Son Case-sensitive, lo que representa una diferencia entre mayusculas y minusculas, 'asdfasdf' es diferente a 'ASDFASDF'
	//-No se pueden usar palabras reservadas como private o public etc
	//-No tienen un limite de longitud

//Declaraciones de identificadoes legales
		int variable;
		int VARIABLE;
		int _____variable;
		int __variable;
		int $variable;
		int $_v_a_r$i$a$b$l$e_;
		int variable12345;
		int _1v2_a$riable;
//Declaraciones de identificadoes ILEGALES
//		int 1variable;
//		int vari%able;
//		int -variable;
//		int variable.1;
//		int /variable;
	}
	
//++++Estandar de codificacion Java:
//Para clases:
//	-Primera letra mayuscula
//	-Formato acamellonado (Letras mayusculas al ingresar una nueva palabra ejemplo de acamellonamiento elAprenderJavaEsDivertido )
//	-Clase es sustantivo (es la raiz de la gestion de objetos, la receta para crear nuevos)
//	-Las Clases internas pueden ser publicas, pero no deberian ser lo
//	-El nombre del archivo debe de llamarse igual que la clase principal
	class ClaseInternaA{
//Para variables:
//	-Primera letra minuscula
//	-Formato acamellonado
		int variableEjemplo;
//Para constantes de no serializacion: 		
//	-Todas las letras mayusculas
//	-Palabras separadas por guiones bajos '_'
		final int CONSTANTE_EJEMPLO =0;
//Para metodos:
//	-Primera letra minuscula
//	-Formato acamellonado		
		public void metodoEjemplo() {}
	}
//Para interfaces:
//	-Primera letra mayuscula
//	-Formato acamellonado
//	-Interfaz es Adjetivo (es la raiz del polimorfismo, a lo que se refiere es que un objeto es un tipo de...)	
	interface InterfaceInternaA{
	}
	
//++++Estandar Clases bien formadas JavaBeans
	private class ClaseInternaJavaBean{
//	-Las variables dentro de un JavaBean tienen que ser privadas por encapsulamiento y alta cohesion
//	-Las variables deben de estar acompañadas por sus accesor metodos publicos getters y setters a excepcion de las variables booleanas cuyo getter se convierte en is		
		private int variableEntera;
		private boolean variableBooleana;

		public int getVariableEntera() {
			return variableEntera;
		}
		public void setVariableEntera(int variableEntera) {
			this.variableEntera = variableEntera;
		}
		public boolean isVariableBooleana() {
			return variableBooleana;
		}
		public void setVariableBooleana(boolean variableBooleana) {
			this.variableBooleana = variableBooleana;
		}
	}
//	-Las variables de tipo Listener (variables objeto que son de un tipo de interfaz 'escucha') tienen el mismo formato en la declaracion que cualquier otra variable
//	-Las variables de tipo Listener NO van acompañadas por metodos accessors getters ni setters, sin embargo para ingresarles valor o removerlo se usan metodos que inician con add o remove respectivamente
	protected class ClaseInternaJavaBeanListener extends Component {
		private String id;
		private MiClaseEventListener miClaseEventListener;

		public void addMiClaseEventListener(MiClaseEventListener miClaseEventListener) {
			this.miClaseEventListener = miClaseEventListener;
		}
		public void removeMiClaseEventListener() {
			miClaseEventListener = null;
		}
	}
	
}



