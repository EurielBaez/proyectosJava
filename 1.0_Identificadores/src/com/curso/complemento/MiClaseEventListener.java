package com.curso.complemento;

public class MiClaseEventListener implements MiEventoListener {
    public void capturarMiEvento( MiEvento evt ) {
        System.out.println("Metodo capturarMiEvento() invocado sobre " + evt.getId() );
        System.out.println("El origen del evento fue " + evt.getSource() );
        }
    }