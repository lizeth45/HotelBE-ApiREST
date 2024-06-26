package com.app.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Cancelacion;
import com.app.hotel.service.ICancelacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class CancelacionController {
	
	@Autowired 
	private ICancelacionService servCancelacion;
	

	@GetMapping("/cancelacion")
	public List<Cancelacion> showAllCancelaciones(){  
		return servCancelacion.consultaGral();
	}
	
	@GetMapping("/cancelacion/{id}")
	public List<Cancelacion> showCancelacionID( @PathVariable("id")int idCancelacion)
	{
		return servCancelacion.consultaCancelacionId(idCancelacion);
	}
	
	@PostMapping("/cancelacion/{idEstancia}/{motivo}")
	public String insertarCancelacion(@PathVariable("idEstancia") int idEstancia, @PathVariable("motivo") String motivo) {
		return servCancelacion.insertCancelacion(idEstancia, motivo);
	}

}
