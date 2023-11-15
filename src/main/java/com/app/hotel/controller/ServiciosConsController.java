package com.app.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.ServiciosCons;
import com.app.hotel.service.IServiciosConsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ServiciosConsController {

	@Autowired 
	private IServiciosConsService servServiciosCons;
	
	@GetMapping("/servcons")
	public List<ServiciosCons> showAll(){
		return servServiciosCons.consultaGral();
	}
	
	@PostMapping("/servcons/{idEstancia}/{desc_serv}")
	public Integer insertarServicioEstancia(@PathVariable("idEstancia") int idEstancia, @PathVariable("desc_serv") String desc_serv){
		return servServiciosCons.agregarServiciosEstancia(idEstancia, desc_serv);
	}
}
