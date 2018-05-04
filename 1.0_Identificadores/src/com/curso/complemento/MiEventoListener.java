package com.curso.complemento;

import java.util.EventListener;

public interface MiEventoListener extends EventListener {
	public void capturarMiEvento(MiEvento evt);
}