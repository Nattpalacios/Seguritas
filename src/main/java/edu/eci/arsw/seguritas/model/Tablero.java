package edu.eci.arsw.seguritas.model;

import java.util.ArrayList;

public class Tablero {
	
	private String id;
	private ArrayList<Actividad> actividades;
	private ArrayList<Nota> notas;
	
	public Tablero() {
		
	}
	
	public Tablero(String id) {
		this.id = id;
		actividades = new ArrayList<Actividad>();
		notas = new ArrayList<Nota>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void agregarActividad(Actividad actividad) {
		actividades.add(actividad);
	}
	
	public void eliminarActividad(Actividad actividad) {
		actividades.remove(actividad);
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void agregarNota(Nota nota) {
		notas.add(nota);
	}
	
	public void eliminarNota(Nota nota) {
		notas.remove(nota);
	}

}
