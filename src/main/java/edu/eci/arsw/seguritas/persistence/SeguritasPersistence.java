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

	public void registrarEdificio(Edificio edificio) throws SeguritasPersistenceException;
	
	public void registrarPiso(String nombreEdificio, Piso piso) throws SeguritasPersistenceException;
	
	public void registrarPuerta(String nombreEdificio, String nombrePiso, Puerta puerta) throws SeguritasPersistenceException;
	
}
