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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Servicio;
import com.app.hotel.service.IServiciosService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/hotelbe")
public class ServicioController {

	@Autowired 
	private IServiciosService servServicio;
	
	//Muestra TODOS los clientes
	@GetMapping("/servicio")
	public List<Servicio> showAllServicios(){  
		return servServicio.consultaGral();
	}
	
	@GetMapping("/servicio/{id}")
	public List<Servicio> showServicioID( @PathVariable("id")int idServicio)
	{
		return servServicio.consultaServicioId(idServicio);
	}
	
	
	//AGREGAR un cliente
	@PostMapping("/servicio")
	public String insertarServicio(@RequestBody Servicio obj){
		servServicio.insertarServicio(obj);
		return "Servicio registrado correctamente";
	}
	
	//ACTUALIZAR un cliente por el id
	@PutMapping("/servicio/{id}")
	public ResponseEntity<Map<String, String>> actServicio(@RequestBody Servicio obj, @PathVariable("id") int idServicio){
		return servServicio.updateServicio(obj, idServicio);
	}
	
	@DeleteMapping("/servicio/{id}")
	public ResponseEntity<Map<String,String>> eliminarServicio(@PathVariable("id") int idServicio){
		return servServicio.eliminarServicio(idServicio);
	}
}
