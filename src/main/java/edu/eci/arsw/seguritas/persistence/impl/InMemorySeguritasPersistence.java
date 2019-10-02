package edu.eci.arsw.seguritas.persistence.impl;

import java.util.ArrayList;

import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistence;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;

public class InMemorySeguritasPersistence implements SeguritasPersistence {

	@Override
	public ArrayList<Edificio> obtenerEdificios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piso obtenerPiso(String nombreEdificio, String nombrePiso) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Puerta obtenerPuerta(String nombreEdificio, String nombrePiso, String nombrePuerta)
			throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarEdificio(Edificio edificio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPiso(Edificio edificio, Piso piso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPuerta(Edificio edificio, Piso piso, Puerta puerta) {
		// TODO Auto-generated method stub
		
	}

}
