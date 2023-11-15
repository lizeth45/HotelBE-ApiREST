package com.app.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.dto.NewReservaHabPL;
import com.app.hotel.entity.ReservaHab;
import com.app.hotel.service.IReservacionHabService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ReservaHabController {

	@Autowired 
	private IReservacionHabService servReservacionHab;
	
	@GetMapping("/reservasHab")
	public List<ReservaHab> showAll(){
		return servReservacionHab.consultaGral();
	}
	
	@PostMapping("/reservasHab/newReservaHab")
	public ResponseEntity<String> newReservaHab(@RequestBody NewReservaHabPL obj){
        return ResponseEntity.ok(servReservacionHab.newReservaHab(obj.getFechaLlegada(), obj.getFechaSalida(), obj.getTipoHab()));
    }
}
