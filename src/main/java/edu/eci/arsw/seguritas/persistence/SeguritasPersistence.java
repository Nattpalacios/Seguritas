package edu.eci.arsw.seguritas.persistence;

import java.util.ArrayList;

import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;

public interface SeguritasPersistence {
	
	public ArrayList<Edificio> obtenerEdificios();
	
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException;
	
	public Piso obtenerPiso(String nombreEdificio, String nombrePiso) throws SeguritasPersistenceException;
	
	public Puerta obtenerPuerta(String nombreEdificio, String nombrePiso, String nombrePuerta) throws SeguritasPersistenceException;

	public void registrarEdificio(Edificio edificio);
	
	public void registrarPiso(Edificio edificio, Piso piso);
	
	public void registrarPuerta(Edificio edificio, Piso piso, Puerta puerta);
	
}
