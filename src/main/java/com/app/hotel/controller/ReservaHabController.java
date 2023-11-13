package com.app.hotel.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.ReservaHab;
import com.app.hotel.service.IReservacionHabService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ReservaHabController {

	@Autowired 
	private IReservacionHabService servReservacionHab;
	
	@GetMapping("reservasHab/")
	public List<ReservaHab> showAll(){
		return servReservacionHab.consultaGral();
	}
	
	@PutMapping("reservasHab/newReservaHab/{pfechaLlegada}/{pfechaSalida}/{ptipoHabitacion}")
	public ResponseEntity<Integer> newReservaHab(
		@RequestParam("pfechaLlegada") Date fechaLlegada,
		@RequestParam("pfechaSalida") Date fechaSalida,
		@RequestParam("ptipoHabitacion") String tipoHab
    ){
        return ResponseEntity.ok(servReservacionHab.newReservaHab(fechaLlegada, fechaSalida, tipoHab));
    }
}
