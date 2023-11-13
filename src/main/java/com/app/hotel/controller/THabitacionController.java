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

import com.app.hotel.entity.TipoHabitacion;
import com.app.hotel.service.ITipoHabitacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class THabitacionController {

	@Autowired 
	private ITipoHabitacionService servTHab;
	
	@GetMapping("/tipohab")
	public List<TipoHabitacion> showAllTiposHab(){  
		return servTHab.consultaGral();
	}
	
	@GetMapping("/tipohab/{descTHab}")
	public List<TipoHabitacion> showTipoHabDesc( @PathVariable("descTHab")String descTHab){
		return servTHab.consultaTipoHabDesc(descTHab);
	}
	
	
	@PostMapping("/tipohab")
	public String insertarTipoHab(@RequestBody TipoHabitacion objTHab){
		servTHab.insertarTHab(objTHab);
		return "Tipo habitacion registrado correctamente";
	}
	
	@PutMapping("/tipohab/{id}")
	public ResponseEntity<Map<String, String>> actThab(@RequestBody TipoHabitacion obj, @PathVariable("id") int idTHab){
		return servTHab.updateTHab(obj, idTHab);
	}
	
	@DeleteMapping("/tipohab/{id}")
	public ResponseEntity<Map<String,String>> eliminarTHab(@PathVariable("id") int idTHab){
		return servTHab.eliminarTHabitacion(idTHab);
	}
}
