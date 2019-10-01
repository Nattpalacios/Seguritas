package edu.eci.arsw.seguritas.model;

import java.util.ArrayList;

public class Tablero {
	
	private String id;
	private ArrayList<Actividad> actividades;
	private ArrayList<Nota> notas;
	
	public Tablero() {
		
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

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

}
