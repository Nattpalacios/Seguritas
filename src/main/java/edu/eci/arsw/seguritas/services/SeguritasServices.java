package edu.eci.arsw.seguritas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistence;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;

public interface SeguritasServices {
	
	public ArrayList<String> obtenerEdificios();
	
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException;
	
	public Piso obtenerPiso(String nombreEdificio, String nombrePiso) throws SeguritasPersistenceException;
	
	public Puerta obtenerPuerta(String nombreEdificio, String nombrePiso, String nombrePuerta) throws SeguritasPersistenceException;
	
	public void registrarEdificio(Edificio edificio) throws SeguritasPersistenceException;
	
	public void registrarPiso(String nombreEdificio, Piso piso) throws SeguritasPersistenceException;
	
	public void registrarPuerta(String edificio, String piso, Puerta puerta) throws SeguritasPersistenceException;
	
	public void modificarNombreEdificio(String nombreActual, Edificio nuevo) throws SeguritasPersistenceException;
	
	public void removerPiso(String edificio, Edificio nuevoEdificio) throws SeguritasPersistenceException;
	
	public void removerEdificio(String edificio) throws SeguritasPersistenceException;

}
