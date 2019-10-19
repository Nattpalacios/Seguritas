package edu.eci.arsw.seguritas.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;
import edu.eci.arsw.seguritas.services.SeguritasServices;

@RestController
@RequestMapping("/seguritas")
public class PisosAPIController {
	
	@Autowired
	SeguritasServices ss = null;
	
	@GetMapping("/edificios/{edificio}/pisos/{piso}")
	   public ResponseEntity<?> obtenerPiso(@PathVariable ("edificio") String nombreEdificio, @PathVariable ("piso") String nombrePiso){
	       try {
	           return new ResponseEntity<>(ss.obtenerPiso(nombreEdificio, nombrePiso),HttpStatus.ACCEPTED);
	       } catch (Exception e) {
	           Logger.getLogger(PisosAPIController.class.getName()).log(Level.SEVERE, null, e);
	           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	       }        
	   }
	
	@PostMapping("/edificios/{edificio}/pisos")
	   public ResponseEntity<?> registrarPiso(@PathVariable ("edificio") String nombreEdificio, @RequestBody Piso piso){
	       try {
	           ss.registrarPiso(nombreEdificio, piso);
	           return new ResponseEntity<>(HttpStatus.CREATED);
	       } catch (Exception e) {
	           return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	       }
	   }

}
