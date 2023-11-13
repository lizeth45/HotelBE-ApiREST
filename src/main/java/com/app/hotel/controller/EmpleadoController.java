package com.app.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Empleado;
import com.app.hotel.service.IEmpleadoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class EmpleadoController {

	@Autowired 
	private IEmpleadoService servEmpleado;
	
	@GetMapping("/empleado")
	public List<Empleado> showAllEmpleados(){  
		return servEmpleado.showAllEmpleados();
	}
	
	@GetMapping("/empleado/{user}/{pass}")
	public List<Empleado> showEmpleadoLongin( @PathVariable("user")String user,  @PathVariable("pass")String pass)
	{
		return servEmpleado.consultaEmpleadoLogin(user, pass);
		
	}
	
	@PostMapping("/empleado/new")
	public String insertarEmpleado(@RequestBody Empleado obj){
		servEmpleado.insertarEmpleado(obj);
		return "Empleado registrado correctamente";
	}
}
