package edu.eci.arsw.seguritas.services.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistence;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;
import edu.eci.arsw.seguritas.services.SeguritasServices;

@Component
public class SeguritasServicesImpl implements SeguritasServices{
	
	@Autowired
	SeguritasPersistence sp;
	
	public ArrayList<Edificio> obtenerEdificios() {
		ArrayList<Edificio> edific = sp.obtenerEdificios();
		/*ArrayList<String> nombresEdif = new ArrayList<>();
		for (Edificio e : edific) {
			nombresEdif.add(e.getNombre());
		}
		return nombresEdif;*/
		return edific;
	}
	
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException {
		Edificio e = sp.obtenerEdificio(nombreEdificio);
		if (e != null) {
			return e;
		}else {
			throw new SeguritasPersistenceException("No se encontró el edificio.");
		}
	}
	
	public Piso obtenerPiso(String nombreEdificio, String nombrePiso) throws SeguritasPersistenceException {
		Piso p = sp.obtenerPiso(nombreEdificio, nombrePiso);
		if(p != null) {
			return p;
		}else {
			throw new SeguritasPersistenceException("No se encontró el piso.");
		}
	}
	
	public Puerta obtenerPuerta(String nombreEdificio, String nombrePiso, String nombrePuerta) throws SeguritasPersistenceException {
		Puerta p = sp.obtenerPuerta(nombreEdificio, nombrePiso, nombrePuerta);
		if(p != null) {
			return p;
		}else {
			throw new SeguritasPersistenceException("No se encontró la puerta.");
		}
	}
	
	public void registrarEdificio(Edificio edificio) throws SeguritasPersistenceException{
		sp.registrarEdificio(edificio);
	}
	
	public void registrarPiso(String nombreEdificio, Piso piso) throws SeguritasPersistenceException{
		sp.registrarPiso(nombreEdificio, piso);
	}
	
	public void registrarPuerta(String edificio, String piso, Puerta puerta) throws SeguritasPersistenceException{
		sp.registrarPuerta(edificio, piso, puerta);
	}
	
	public void modificarNombreEdificio(String nombreActual, Edificio nuevo) throws SeguritasPersistenceException{
		sp.modificarNombreEdificio(nombreActual, nuevo);
	}

	@Override
	public void removerPiso(String edificio, Edificio nuevoEdificio) throws SeguritasPersistenceException {
		sp.removerPiso(edificio, nuevoEdificio);
	}

	@Override
	public void removerEdificio(String edificio) throws SeguritasPersistenceException {
		sp.removerEdificio(edificio);		
	}

}
