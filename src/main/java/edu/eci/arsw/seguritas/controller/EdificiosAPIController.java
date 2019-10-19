package edu.eci.arsw.seguritas.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.persistence.SeguritasPersistenceException;
import edu.eci.arsw.seguritas.services.SeguritasServices;

@RestController
@RequestMapping("/seguritas")
public class EdificiosAPIController {

   @Autowired
   SeguritasServices ss = null;
   
   @GetMapping("/edificios")
   public ResponseEntity<?> obtenerEdificios(){
       try {
           return new ResponseEntity<>(ss.obtenerEdificios(),HttpStatus.ACCEPTED);
       } catch (Exception e) {
           Logger.getLogger(EdificiosAPIController.class.getName()).log(Level.SEVERE, null, e);
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
       }
   }

   @GetMapping("/edificios/{edificio}")
   public ResponseEntity<?> obtenerEdificio(@PathVariable ("edificio") String nombreEdificio){
       try {
           return new ResponseEntity<>(ss.obtenerEdificio(nombreEdificio),HttpStatus.ACCEPTED);
       } catch (Exception e) {
           Logger.getLogger(EdificiosAPIController.class.getName()).log(Level.SEVERE, null, e);
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
       }        
   }
      
   @PostMapping("/edificios")
   public ResponseEntity<?> registrarEdificio(@RequestBody Edificio edificio){
       try {
           ss.registrarEdificio(edificio);
           return new ResponseEntity<>(HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
       }
   }
   
   @PutMapping("/edificios/{nombreActual}")
   public ResponseEntity<?> modificarNombreEdificio(@PathVariable("nombreActual")String nombreActual,@RequestBody Edificio nuevo){
	   try {
	       ss.modificarNombreEdificio(nombreActual, nuevo);
	       return new ResponseEntity<>(HttpStatus.CREATED);
	   } catch (SeguritasPersistenceException e) {
	       return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	   }
	}
   
   @PutMapping("/edificios/{edificio}/removerPiso")
   public ResponseEntity<?> removerPiso(@PathVariable("edificio")String edificio, @RequestBody Edificio nuevoEdificio){
	   try {
	       ss.removerPiso(edificio, nuevoEdificio);
	       return new ResponseEntity<>(HttpStatus.CREATED);
	   } catch (SeguritasPersistenceException e) {
	       return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	   }
	}
   
   @DeleteMapping("/edificios/{edificio}")
   public ResponseEntity<?> removerEdificio(@PathVariable("edificio")String edificio){
	   try {
	       ss.removerEdificio(edificio);
	       return new ResponseEntity<>(HttpStatus.CREATED);
	   } catch (SeguritasPersistenceException e) {
	       return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	   }
	}
}