package edu.eci.arsw.seguritas.model;

import java.util.ArrayList;

public class Piso {
	
	private String id;
	private String nombre;
	private ArrayList<Puerta> puertas;
	
	public Piso() {
		
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

	public void setPuertas(ArrayList<Puerta> puertas) {
		this.puertas = puertas;
	}

}
