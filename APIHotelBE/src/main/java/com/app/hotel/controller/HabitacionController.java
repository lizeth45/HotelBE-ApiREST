package com.app.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Habitacion;
import com.app.hotel.service.IHabitacionService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
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
}
