package edu.eci.arsw.seguritas.persistence.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.model.Tablero;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistence;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;

@Service
public class InMemorySeguritasPersistence implements SeguritasPersistence {
	
	private final HashMap<String, Edificio> edificios = new HashMap<>();
	
	public InMemorySeguritasPersistence() {
		Tablero t1 = new Tablero("t1");
		ArrayList<Piso> pisos1 = new ArrayList<>();
		Piso p = new Piso("p1", "Piso 1");
		Puerta p1 = new Puerta("pu1", "F-1");
		p.agregarPuerta(p1);
		pisos1.add(p);
		ArrayList<Piso> pisos2 = new ArrayList<>();
		Piso p2 = new Piso("p2", "Piso 2");
		pisos2.add(p2);
		Edificio e1 = new Edificio("e1", "Fundadores", t1, pisos1);
		Tablero t2 = new Tablero("t2");
		Edificio e2 = new Edificio("e2", "Administrativo", t2, pisos2);
		Tablero t3 = new Tablero("t3");
		Edificio e3 = new Edificio("e3", "Laboratorios", t3, null);
		edificios.put(e1.getNombre(), e1);
		edificios.put(e2.getNombre(), e2);
		edificios.put(e3.getNombre(), e3);
	}
	
	@Override
	public ArrayList<Edificio> obtenerEdificios() {
		Collection<Edificio> coleccion = edificios.values();
		ArrayList<Edificio> edific = new ArrayList<>(coleccion);
		return edific;
	}

	@Override
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException {
		return edificios.get(nombreEdificio);
	}

	@Override
	public Piso obtenerPiso(String nombreEdificio, String nombrePiso) throws SeguritasPersistenceException {
		Edificio e = edificios.get(nombreEdificio);
		ArrayList<Piso> pisos = e.getPisos();
		Piso piso = null;
		for(int i = 0; i < pisos.size(); i++) {
			if (pisos.get(i).getNombre().equals(nombrePiso)) {
				piso = pisos.get(i);
			}
		}
		return piso;
	}

	@Override
	public Puerta obtenerPuerta(String nombreEdificio, String nombrePiso, String nombrePuerta) throws SeguritasPersistenceException {
		Edificio e = edificios.get(nombreEdificio);
		ArrayList<Piso> pisos = e.getPisos();
		Puerta puerta = null;
		for(int i = 0; i < pisos.size(); i++) {
			if (pisos.get(i).getNombre().equals(nombrePiso)) {
				ArrayList<Puerta> puertas = pisos.get(i).getPuertas();
				for (int j = 0; j < puertas.size(); j++) {
					if(puertas.get(j).getNombre().equals(nombrePuerta)) {
						puerta = puertas.get(j);
					}
				}
			}
		}
		return puerta;
	}

	@Override
	public void registrarEdificio(Edificio edificio) throws SeguritasPersistenceException {
		if(edificios.containsKey(edificio.getNombre())) {
			throw new SeguritasPersistenceException("Ya existe un edificio con el nombre: " + edificio.getNombre());
		}else {
			edificios.put(edificio.getNombre(), edificio);
		}		
	}

	@Override
	public void registrarPiso(String nombreEdificio, Piso piso) throws SeguritasPersistenceException {
		Piso p = obtenerPiso(nombreEdificio, piso.getNombre());
		if(p != null) {
			throw new SeguritasPersistenceException("Ya existe un piso con el nombre: " + piso.getNombre());
		}else {
			Edificio e = obtenerEdificio(nombreEdificio);
			e.agregarPiso(piso);
		}	
		
	}

	@Override
	public void registrarPuerta(String nombreEdificio, String nombrePiso, Puerta puerta) throws SeguritasPersistenceException{
		Puerta p = obtenerPuerta(nombreEdificio, nombrePiso, puerta.getNombre());
		if(p != null) {
			throw new SeguritasPersistenceException("Ya existe una puerta con el nombre: " + puerta.getNombre());
		}else {
			Piso piso = obtenerPiso(nombreEdificio, nombrePiso);
			piso.agregarPuerta(puerta);
		}
	}

}
