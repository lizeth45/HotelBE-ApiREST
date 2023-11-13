package com.app.hotel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.service.IReservacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ReservacionController {

	
	@Autowired 
	private IReservacionService servReservacion;
	
	
//	@GetMapping("/reservas/dia")
//	public List<Object[]> showReservDDia(){  
//		return servReservacion.reservaPenddelDia();
//	}
}
