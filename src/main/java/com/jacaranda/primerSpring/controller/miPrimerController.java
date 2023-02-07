package com.jacaranda.primerSpring.controller;

import java.util.List;

import javax.lang.model.util.Elements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.primerSpring.model.element;
import com.jacaranda.primerSpring.model.elementNotFoundException;
import com.jacaranda.primerSpring.service.ElementService;

@RestController
public class miPrimerController {

	@Autowired
	private ElementService servicio;

	@GetMapping("/hola")
	public String getHola() {
		return "hola";
	}

	@GetMapping({"/", "/element"})
	public ResponseEntity<?> findAll() {
		List<element> listElements = servicio.findAll();
		if(listElements.size()!=0) {
			return ResponseEntity.ok(listElements);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/element/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
	element result = servicio.findById(id);
	if (result == null ) {
		throw new elementNotFoundException(id);
	}else {
	return ResponseEntity.ok(result);
	}
	}


	@PostMapping( "/element/")
	public ResponseEntity<?> add(@RequestBody element elemento) {
		
		if(servicio.findById(elemento.getId()) !=null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ese usuario ya existe");
		}
				
		try {
		element resultado = servicio.save(elemento);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());		}
		}
		
	

	@PutMapping("/element/{id}")
	public ResponseEntity<?> edit(@RequestBody element elemento, @PathVariable Integer id) {
		 element result = servicio.findById(id);
		if (result == null) {
			elemento.setId(id);
			return ResponseEntity.ok(elemento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/element/{id}")
	public ResponseEntity<?> edit(@PathVariable Integer id) {
		 element result = servicio.findById(id);
		if (result != null) {
			servicio.delete(result);
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
