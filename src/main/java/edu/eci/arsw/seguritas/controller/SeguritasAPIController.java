package edu.eci.arsw.seguritas.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.seguritas.model.Edificio;
import edu.eci.arsw.seguritas.model.Piso;
import edu.eci.arsw.seguritas.model.Puerta;
import edu.eci.arsw.seguritas.services.SeguritasServices;

@RestController
@RequestMapping("/seguritas")
public class SeguritasAPIController {

   @Autowired
   SeguritasServices ss = null;
   
   @GetMapping("/edificios")
   public ResponseEntity<?> obtenerEdificios(){
       try {
           return new ResponseEntity<>(ss.obtenerEdificios(),HttpStatus.ACCEPTED);
       } catch (Exception e) {
           Logger.getLogger(SeguritasAPIController.class.getName()).log(Level.SEVERE, null, e);
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
       }
   }

   @GetMapping("/edificios/{edificio}")
   public ResponseEntity<?> obtenerEdificio(@PathVariable ("edificio") String nombreEdificio){
       try {
           return new ResponseEntity<>(ss.obtenerEdificio(nombreEdificio),HttpStatus.ACCEPTED);
       } catch (Exception e) {
           Logger.getLogger(SeguritasAPIController.class.getName()).log(Level.SEVERE, null, e);
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
       }        
   }
      
   @GetMapping("/edificios/{edificio}/pisos/{piso}")
   public ResponseEntity<?> obtenerPiso(@PathVariable ("edificio") String nombreEdificio, @PathVariable ("piso") String nombrePiso){
       try {
           return new ResponseEntity<>(ss.obtenerPiso(nombreEdificio, nombrePiso),HttpStatus.ACCEPTED);
       } catch (Exception e) {
           Logger.getLogger(SeguritasAPIController.class.getName()).log(Level.SEVERE, null, e);
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
       }        
   }
   
   @GetMapping("/edificios/{edificio}/pisos/{piso}/puertas/{puerta}")
   public ResponseEntity<?> obtenerPuerta(@PathVariable ("edificio") String nombreEdificio, @PathVariable ("piso") String nombrePiso, @PathVariable ("puerta") String nombrePuerta){
       try {
           return new ResponseEntity<>(ss.obtenerPuerta(nombreEdificio, nombrePiso, nombrePuerta),HttpStatus.ACCEPTED);
       } catch (Exception e) {
           Logger.getLogger(SeguritasAPIController.class.getName()).log(Level.SEVERE, null, e);
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
   
   @PostMapping("/edificios/{edificio}/pisos")
   public ResponseEntity<?> registrarPiso(@PathVariable ("edificio") String nombreEdificio, @RequestBody Piso piso){
       try {
           ss.registrarPiso(nombreEdificio, piso);
           return new ResponseEntity<>(HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
       }
   }
   
   @PostMapping("/edificios/{edificio}/pisos/{piso}/puertas")
   public ResponseEntity<?> registrarPuerta(@PathVariable ("edificio") String nombreEdificio, @PathVariable ("piso") String nombrePiso, @RequestBody Puerta puerta){
       try {
           ss.registrarPuerta(nombreEdificio, nombrePiso, puerta);
           return new ResponseEntity<>(HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
       }
   }
   
}