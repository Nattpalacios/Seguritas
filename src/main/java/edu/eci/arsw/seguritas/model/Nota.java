package edu.eci.arsw.seguritas.model;

public class Nota {
	
	private String id;
	private String descripcion;
	private Guardia autor;
	
	public Nota(String id, String descripcion, Guardia autor) {
		this.id = id;
		this.descripcion = descripcion;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Guardia getAutor() {
		return autor;
	}

	public void setAutor(Guardia autor) {
		this.autor = autor;
	}

}
