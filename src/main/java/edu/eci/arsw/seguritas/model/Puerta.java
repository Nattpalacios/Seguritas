package edu.eci.arsw.seguritas.model;

public class Puerta {

	private String id;
	private String nombre;
	private Estado estado;
	
	public Puerta() {
		
	}
	
	public Puerta(String id, String nombre) {
		estado = estado.CERRADA;
		this.id = id;
		this.nombre = nombre;
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

	public Estado getEstado() {
		return estado;
	}

	public void abrir() {
		estado = estado.ABIERTA;
	}
	
	public void cerrar() {
		estado = estado.CERRADA;
	}
	
}
