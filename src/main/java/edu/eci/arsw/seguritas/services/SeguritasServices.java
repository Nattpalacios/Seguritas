package edu.eci.arsw.seguritas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistence;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;

@Service
public class SeguritasServices {
	
	@Autowired
	SeguritasPersistence sp;
	
	public ArrayList<Edificio> obtenerEdificios() {
		return sp.obtenerEdificios();
	}
	
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException {
		Edificio e = sp.obtenerEdificio(nombreEdificio);
		if (e != null) {
			return e;
		}else {
			throw new SeguritasPersistenceException("No se encontró el edificio.");
		}
		//return sp.obtenerEdificio(nombreEdificio);
	}
	
	public Piso obtenerPiso(String nombreEdificio, String nombrePiso) throws SeguritasPersistenceException {
		Piso p = sp.obtenerPiso(nombreEdificio, nombrePiso);
		if(p != null) {
			return p;
		}else {
			throw new SeguritasPersistenceException("No se encontró el piso.");
		}
		//return sp.obtenerPiso(nombreEdificio, nombrePiso);
	}
	
	public Puerta obtenerPuerta(String nombreEdificio, String nombrePiso, String nombrePuerta) throws SeguritasPersistenceException {
		Puerta p = sp.obtenerPuerta(nombreEdificio, nombrePiso, nombrePuerta);
		if(p != null) {
			return p;
		}else {
			throw new SeguritasPersistenceException("No se encontró la puerta.");
		}
		//return sp.obtenerPuerta(nombreEdificio, nombrePiso, nombrePuerta);
	}
	
	public void registrarEdificio(Edificio edificio) {
		sp.registrarEdificio(edificio);
	}
	
	public void registrarPiso(Edificio edificio, Piso piso) {
		sp.registrarPiso(edificio, piso);
	}
	
	public void registrarPuerta(Edificio edificio, Piso piso, Puerta puerta) {
		sp.registrarPuerta(edificio, piso, puerta);
	}

}
