package com.app.hotel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Estancia;
import com.app.hotel.service.IEstanciaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class EstanciaController {
	
	@Autowired 
	private IEstanciaService servEstancia;
	
	@GetMapping("/estancia")
	public List<Estancia> showAllEstancias(){  
		return servEstancia.consultaGral();
	}
	
	@GetMapping("/estancia/lastID")
	public List<Estancia> ultimoIdEstancia(){  
		return servEstancia.ultimoIDEstancia();
	}
	
	@GetMapping("/estancia/{id}")
	public List<Estancia> showEstanciaID( @PathVariable("id")int idEstancia)
	{
		return servEstancia.consultaEstanciaId(idEstancia);
	}

	@DeleteMapping("/estancia/{id}")
	public ResponseEntity<Map<String,String>> eliminarEstancia(@PathVariable("id") int idEstancia){
		return servEstancia.eliminarEstancia(idEstancia);
	}
	
	@PostMapping("/estancia/newEstancia")
	public ResponseEntity<Map<String, String>> newEstancia(@RequestBody Estancia obj){
		return servEstancia.newEstancia(obj);
	}
}
