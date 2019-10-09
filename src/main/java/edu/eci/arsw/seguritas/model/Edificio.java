package edu.eci.arsw.seguritas.model;

import java.util.ArrayList;

public class Edificio {
	
	private String id;
	private String nombre;
	private Tablero tablero;
	private ArrayList<Piso> pisos;
	
	public Edificio() {
		
	}
	
	public Edificio(String id, String nombre, Tablero tablero, ArrayList<Piso> pisos) {
		this.id = id;
		this.nombre = nombre;
		this.tablero = tablero;
		if (pisos == null) {
			this.pisos = new ArrayList<>();
		}else {
			this.pisos = pisos;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public void agregarPiso(Piso piso) {
		pisos.add(piso);
	}
	
	public void quitarPiso(Piso piso) {
		pisos.remove(piso);
	}
	
}
