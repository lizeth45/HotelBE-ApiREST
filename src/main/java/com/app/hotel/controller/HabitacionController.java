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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Habitacion;
import com.app.hotel.service.IHabitacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class HabitacionController {

	@Autowired 
	private IHabitacionService servHabitacion;
	
	@GetMapping("/habitacion")
	public List<Habitacion> showAllHabitaciones(){  
		return servHabitacion.consultaGral();
	}
	
	@GetMapping("/habitacion/{id}")
	public List<Habitacion> showHabitacionID( @PathVariable("id")int idHabitacion)
	{
		return servHabitacion.consultaHabitacionId(idHabitacion);
	}
	
	@PostMapping("/habitacion")
	public String insertarHab(@RequestBody Habitacion obj){
		servHabitacion.insertarHabitacion(obj);
		return "Habitacion registrada correctamente";
	}
	
	@PutMapping("/habitacion/{id}")
	public ResponseEntity<Map<String, String>> acthab(@RequestBody Habitacion obj, @PathVariable("id") int idHab){
		return servHabitacion.updateHabitacion(obj, idHab);
	}
	
	@DeleteMapping("/habitacion/{id}")
	public ResponseEntity<Map<String,String>> eliminarHab(@PathVariable("id") int idHab){
		return servHabitacion.eliminarHab(idHab);
	}
}
