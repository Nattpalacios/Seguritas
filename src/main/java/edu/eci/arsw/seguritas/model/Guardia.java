package edu.eci.arsw.seguritas.model;

public class Guardia {
	
	private String nombre;
	private String correo;
	private int identificacion;
	
	public Guardia(String nombre, String correo, int identificacion) {
		this.nombre = nombre;
		this.correo = correo;
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

}
