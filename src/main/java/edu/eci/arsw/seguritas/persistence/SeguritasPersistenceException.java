package edu.eci.arsw.seguritas.persistence;

public class SeguritasPersistenceException extends Exception{
	
	public SeguritasPersistenceException(String message) {
        super(message);
    }

    public SeguritasPersistenceException(String message, Throwable cause) {
        super(message, cause);
    } 

}