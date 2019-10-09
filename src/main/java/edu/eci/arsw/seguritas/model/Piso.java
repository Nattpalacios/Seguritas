package edu.eci.arsw.seguritas.model;

import java.util.ArrayList;

public class Piso {
	
	private String id;
	private String nombre;
	private ArrayList<Puerta> puertas;
	
	public Piso() {
		
	}
	
	public Piso(String id, String nombre, ArrayList<Puerta> puertas) {
		this.id = id;
		this.nombre = nombre;
		this.puertas = puertas;
		if(puertas == null) {
			this.puertas = new ArrayList<>();
		}else {
			this.puertas = puertas;
		}
	}
	
	public Piso(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		puertas = new ArrayList<>();
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

	public ArrayList<Puerta> getPuertas() {
		return puertas;
	}

	public void agregarPuerta(Puerta puerta) {
		puertas.add(puerta);
	}
	
	public void quitarPuerta(Puerta puerta) {
		puertas.remove(puerta);
	}

}
