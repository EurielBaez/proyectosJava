package com.curso.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainClass implements Serializable{
	
	private int variablePrivate;
	protected int variableProtected;
	int variableDefault;
	public int variablePublic;
	
	private void metodoPrivate() {}
	protected void metodoProtected() {}
	void metodoDefault() {}
	public void metodoPublic() {}
	
	public static void main(String[] args) {
//++++++Los modificadores de acceso en java son 4 public, private, protected y default estos nos permiten conservar la administracion 
//	de la visibilidad de variables, metodos y clases esto es parte de la accesibilidad de las mismas
//		-private es el modificador de acceso mas restricctivo, solamente la clase y metodos de la misma pueden acceder 
//			directamente a la variable o al metodo una clase puede ser privada solamente si es interna de otra
//		-default modificador que permite la visibilidad por miembros que comparten el mismo paquete
//		-protected modificador que refiere la accesibilidad por herencia a solo los miembros de las clases que la hereden
//			indirectamente al igual que las clases que comparten el mismo paquete 
//		-public modificador que indica que cualquier clase en cualquier paquete puede usarlo
	
		
//++++++Modificadores de Herencia para clase, estos modificadoras indica si una clase se tiene que heredar o que no se puede heredar
//		-final (este modificador tambien es aplicable para variables y metodos con diferente significado) no se puede heredar
//		-abstract que la clase se tiene que heradar no se puede instanciar
		new MainClass().new ClaseFinalDetalle();
		
		new MainClass().new ClaseFinal();
//	Una clase Abstracta no puede ser instanciada la siguiente linea generar error:
//		new MainClass.ClaseAbstracta();
		new MainClass().new ClaseAbstractaHeredada();
		
//	Las clases internas estaticas pueden instanciarse sin la necesidad de instanciar la clase superior
//	Dentro del cuerpo de la clase la instanciacion de una clase interna estatica puede ser implicita como sigue:
		new ClaseStatic();
//	Fuera del cuerpo de la clase la instanciacion de una clase interna estatica debe de ser explicita como sigue:	
		new MainClass.ClaseStatic();
		
		ClaseTrasient claseTrasient = new MainClass().new ClaseTrasient();
		try {
			claseTrasient.guardarArchivoObjeto();
			claseTrasient.leerArchivoObjeto();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	final class ClaseFinal {}
	abstract class ClaseAbstracta{}
	
//	Una clase no puede heredar de una clase final, la siguente linea genera error:
//	class ClaseFinalHeredada extends ClaseFinal{}
	public class ClaseAbstractaHeredada extends ClaseAbstracta{}
	
//++++++Las Clases abstractas 
//	-Pueden o no tener metodos abstractos, pero una clase con que solo uno de sus metodos sea abstracto convierte a la clase en abstraca
//	-Los metodos abstractos no deben de tener cuerpo {} solo terminan con ; despues de su declaracion
//	-La clase que la herede debe de ser abstracta o implementar los metodos abstractos
//	-Los metodos abstractos no pueden ser privados ya que esto evitaria que cumpla su proposito de ser sobreescrito
//	-abstract solo es usado en clase y metodos no en variables
	abstract class ClaseAbstractaDetalle{
		public void metodoNoAbstractoLegal() {}
//	Los metodos sin cuerpo que solo vienen con la definicion tienen que ser abstractos o tener cuerpo por lo que esta linea
//	genera un error:
//		public void metodoNoAbstractoIlegal();
		
		public abstract void metodoAbstractoLegal();
//	Los metodos definidos con el modificador abstract no llevan cuerpo por lo que esta linea genera un error: 
//		public abstract void metodoAbstractoIlegal(){}
		
//	Los metodos abstractos deben de ser sobreescritos por lo cual el modificador private no puede ser aplicado a estos metodos
//	por lo cual esta linea generar error:
//		private abstract void metodoAbstractoPrivadoIlegal();
		abstract void metodoAbstractoDefaultLegal();
		protected abstract void metodoAbstractoProtectedLegal();
		public abstract void metodoAbstractoPublicLegal();
	}
//++++++Modificador final para variables y metodos
//	-final es el modificador que indica que son constantes
//	-final en un metodo indica que este no pueden ser sobreescrito por la clase que herede 
	class ClaseFinalDetalle{
		public final int CONSTANTE = 2;
		public final void metodoFinal() {}
		public void metodoNoFinal() {}
	}
	class ClaseFinalDetalleComplemento extends ClaseFinalDetalle{
//	Los metodos definidos como finales no pueden ser sobreescritos por lo cual esta linea genera error: 
//		public void metodoFinal() {}
		public void metodoNoFinal() {}
	}
//++++++Modificador de Clase este modificador indica la pertenencia de una variable o metodo, indica si le pertenece a los objetos generados o a la Clase
//	-Las clases pueden ser estaticas, esto hace que la clase interna no se cargue junto con la carga de la clase base
//	-Una clase interna no puede tener variables static a menos que la clase sea static
//	-Las clases estaticas no pueden tener referencia a los contextos de su clase contenedora que no sean static
	public static class ClaseStatic{
		private  int variableInstancia;
		private  static int variableStatic;
		
		public void metodoInstancia() {
			variableInstancia = 10;
// Un metodo de instancia SI puede acceder a las variables estaticas pues estas existen sin la necesidad de una instacia			
			variableStatic = 10;
		}
		public static void metodoStatic() {
//	Un metodo estatico no puede tener acceso a variables de instancia por que le pertenece a la instancia no a la clase por lo cual esta linea genera error:
//			variableInstancia = 10;
			variableStatic = 10;
		}
	}
//++++++Modificador de concurrencia synchronized y volatile
//	-volatile es un modificador aplicado a variables para indicar que los hilos no deben de copiar el valor de la variable para operarlo
//	-synchronized es el modificador para hacer que un metodo o bloque no se accedido por 2 hilos al mismo tiempo
	class ClaseVolatileSynchronized{
		private volatile int variableVolatile;
		public synchronized void metodoSynchronized() {}
		public void metodoSynchronizedBloque() {
			synchronized (this) {
			}
		}
	}
//++++++Modificador de Serializacion transient
//	-trasient es el modificador para indicar que una variable al ser tratada de ser enviada o almacenada no se procese 
	class ClaseTrasient implements Serializable{
//		Una clase interna serializada solo puede ser correctamente aplicada si la clase interna superior tambien es serializada
		private static final long serialVersionUID = -6924926539453776025L;
		private transient int variableTransient;
		private  int variableNoTransient;
		
		public ClaseTrasient() {
			variableTransient = 100;
			variableNoTransient = 100;
		}
		public int getVariableTransient() {
			return variableTransient;
		}
		public void setVariableTransient(int variableTransient) {
			this.variableTransient = variableTransient;
		}
		public int getVariableNoTransient() {
			return variableNoTransient;
		}
		public void setVariableNoTransient(int variableNoTransient) {
			this.variableNoTransient = variableNoTransient;
		}
		@Override
		public String toString() {
			return "ClaseTrasient [variableTransient=" + variableTransient + ", variableNoTransient="
					+ variableNoTransient + "]";
		}
		/*Anexo de ejemplificacion del no guardado de la variable trasient*/
		public void guardarArchivoObjeto() throws IOException {
			System.out.println("Objeto al Guardarse:\t"+this);
			File directorio = new File("C:\\temporal");
			if(!directorio.exists()) {
				directorio.mkdirs();
			}
			File archivo = new File("C:\\temporal\\ObjetoGuardadoJava.txt");
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(this);
			oos.close();
		}
		public void leerArchivoObjeto() throws IOException, ClassNotFoundException {
			File archivo = new File("C:\\temporal\\ObjetoGuardadoJava.txt");
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(archivo));
			System.out.println("Objeto al Leerse:\t"+oos.readObject());
			oos.close();
		}
		/*Anexo de ejemplificacion del no guardado de la variable trasient*/
	}
//++++++Modificador estrafalarios native y strictfp 
	
	
}