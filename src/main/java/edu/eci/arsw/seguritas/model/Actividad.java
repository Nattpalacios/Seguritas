package edu.eci.arsw.seguritas.model;

import java.sql.Date;
import java.util.ArrayList;

public class Actividad {
	
	private String id;
	private String descripcion;
	private Date horario;
	private ArrayList<Guardia> asignados;
	
	public Actividad(String id, String descripcion, Date horario) {
		this.id = id;
		this.descripcion = descripcion;
		this.horario = horario;
		asignados = new ArrayList<Guardia>();
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

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public ArrayList<Guardia> getAsignados() {
		return asignados;
	}

	public void agregarAsignado(Guardia asignado) {
		asignados.add(asignado);
	}
	
	public void eliminarAsignado(Guardia asignado) {
		asignados.remove(asignado);
	}

}
