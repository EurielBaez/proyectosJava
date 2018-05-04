package com.curso.complemento;

import java.util.EventObject;

public class MiEvento extends EventObject {
	private static final long serialVersionUID = 1L;
	private String id;

	public MiEvento(Object obj, String id) {
		super(obj);
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}