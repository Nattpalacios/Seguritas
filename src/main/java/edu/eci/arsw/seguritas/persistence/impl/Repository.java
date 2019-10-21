package edu.eci.arsw.seguritas.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistence;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;

@Service
public class Repository implements SeguritasPersistence {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public ArrayList<Edificio> obtenerEdificios() {
		String query = "SELECT * FROM Edificio;";
		ArrayList<Edificio> edificios = new ArrayList<>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
				Edificio subject = new Edificio(id,name,null,null);									
				edificios.add(subject);
			}
			connection.close();
			return edificios;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Edificio obtenerEdificio(String nombreEdificio) throws SeguritasPersistenceException {
		String query = "SELECT * FROM Edificio WHERE name=nombreEdificio;";
		Connection connection = null;
		Edificio edificio = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs != null) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				edificio = new Edificio(id,name,null,null);
			}
			connection.close();
			return edificio;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
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
	public void registrarEdificio(Edificio edificio) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPiso(String nombreEdificio, Piso piso) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPuerta(String nombreEdificio, String nombrePiso, Puerta puerta)
			throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarNombreEdificio(String nombreActual, Edificio nuevo) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPiso(String edificio, Edificio nuevoEdificio) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerEdificio(String edificio) throws SeguritasPersistenceException {
		// TODO Auto-generated method stub
		
	}
}