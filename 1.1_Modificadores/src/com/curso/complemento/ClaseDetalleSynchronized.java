package com.curso.complemento;

import java.util.ArrayList;
import java.util.List;

//La herencia con Thread solo es para la gestion de hilos y se pueda reflejar la funcion de synchronized
public class ClaseDetalleSynchronized extends Thread{
	public static int contador = 0;
	public int modo = 0;
	public int id = 0;
	public boolean hiloTerminado = false;
	
	public ClaseDetalleSynchronized(int id, int modo) {
		this.id= id;
		this.modo = modo;
	}
	
	public static void main(String[] args) {
		try {
			List <ClaseDetalleSynchronized> hilosNoSynchronized = new ArrayList<ClaseDetalleSynchronized>();
			List <ClaseDetalleSynchronized> hilosMetodoSynchronized = new ArrayList<ClaseDetalleSynchronized>();
			List <ClaseDetalleSynchronized> hilosBloqueSynchronized = new ArrayList<ClaseDetalleSynchronized>();
			System.out.println("Ejecucion de conjuntos de hilos NO Synchronized:");
			for (int i = 0; i < 5; i++) {
				hilosNoSynchronized.add(new ClaseDetalleSynchronized(i,0));
				hilosNoSynchronized.get(i).start();
			}
			verificarTerminoEjecucion(hilosNoSynchronized);
			System.out.println("Fin de ejecucion de tareas NO Synchronized contador: "+ contador);
			resetear();
			
			System.out.println("Ejecucion de conjuntos de hilos metodo Synchronized:");
			for (int i = 0; i < 5; i++) {
				hilosMetodoSynchronized.add(new ClaseDetalleSynchronized(i,1));
				hilosMetodoSynchronized.get(i).start();
			}
			verificarTerminoEjecucion(hilosMetodoSynchronized);
			System.out.println("Fin de ejecucion de tareas Metodo Synchronized contador: "+ contador);
			resetear();
			
			System.out.println("Ejecucion de conjuntos de hilos bloque Synchronized:");
			for (int i = 0; i < 5; i++) {
				hilosBloqueSynchronized.add(new ClaseDetalleSynchronized(i,2));
				hilosBloqueSynchronized.get(i).start();
			}
			verificarTerminoEjecucion(hilosBloqueSynchronized);
			System.out.println("Fin de ejecucion de tareas Bloque Synchronized contador: "+ contador);
			resetear();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void verificarTerminoEjecucion(List <ClaseDetalleSynchronized> lista) throws InterruptedException {
		etiquetaWhile:
		while(true) {
			sleep(200);
			for (ClaseDetalleSynchronized token : lista) {
				if(!token.hiloTerminado) {
					continue etiquetaWhile;
				}
			}
			sleep(500);
			break;
		}
	}
	
	public static void resetear() {
		contador = 0;
		eventosSimultaneos= 0;
	}
	
	@Override
	public void run(){
		try {
			if(modo == 0) {
				System.out.println("ClaseDetalleSynchronized.run()-0-"+contador);
				ejecucionNoSyncronized();
			}
			if(modo == 1) {
				System.out.println("ClaseDetalleSynchronized.run()-1-"+contador);
				ejecucionMetodoSyncronized();
			}
			if(modo == 2) {
				System.out.println("ClaseDetalleSynchronized.run()-2-"+contador);
				ejecucionBloqueSyncronized();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static int eventosSimultaneos = 0; 
	public static void metodoNoSyncronized(ClaseDetalleSynchronized x) throws InterruptedException {
		System.out.println("Entra nodo: "+x.id+" en modo: "+x.modo);
		eventosSimultaneos +=1;
		sleep(100);
		contador += 1;
		eventosSimultaneos -=1;
		if(eventosSimultaneos > 1) {
			System.out.println("ClaseDetalleSynchronized.metodoNoSyncronized(): "+eventosSimultaneos);
			}
		System.out.println("Sale nodo: "+x.id+" en modo: "+x.modo);
	}
	public static  synchronized void metodoSyncronized(ClaseDetalleSynchronized x) throws InterruptedException {
		System.out.println("Entra nodo: "+x.id+" en modo: "+x.modo);
		eventosSimultaneos +=1;
		sleep(100);
		contador += 1;
		eventosSimultaneos -=1;
		if(eventosSimultaneos > 1) {
			System.out.println("ClaseDetalleSynchronized.metodoSyncronized(): "+eventosSimultaneos);
			}
		System.out.println("Sale nodo: "+x.id+" en modo: "+x.modo);
	}
	public static void metodoBloqueSyncronized(ClaseDetalleSynchronized x) throws InterruptedException {
		synchronized (ClaseDetalleSynchronized.class){
			System.out.println("Entra nodo: "+x.id+" en modo: "+x.modo);
			eventosSimultaneos +=1;
			sleep(100);
			contador += 1;
			eventosSimultaneos -=1;
			if(eventosSimultaneos > 1) {
				System.out.println("ClaseDetalleSynchronized.metodoBloqueSyncronized(): "+eventosSimultaneos);
				}
			System.out.println("Sale nodo: "+x.id+" en modo: "+x.modo);
		}
		
	}
	
	public void ejecucionNoSyncronized() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			metodoNoSyncronized(this);
		}
		hiloTerminado = true;
	}
	public void ejecucionMetodoSyncronized() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			metodoSyncronized(this);
		}
		hiloTerminado = true;
	}
	public void ejecucionBloqueSyncronized() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			metodoBloqueSyncronized(this);
		}
		hiloTerminado = true;
	}
	
	
}

















