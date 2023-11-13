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

import com.app.hotel.entity.Reservacion;
import com.app.hotel.service.IReservacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ReservacionController {

	
	@Autowired 
	private IReservacionService servReservacion;
	
	@GetMapping("reservas/")
	public List<Reservacion> showAll(){
		return servReservacion.consultaGralReservacion();
	}
	
	@GetMapping("reservas/verificar-disponibilidad/{pfechaLlegada}/{pfechaSalida}/{ptipoHabitacion}/{pcantidadSolicitada}")
	public ResponseEntity<Integer> verificarDisponibilidad(
        @RequestParam("pfechaLlegada") Date fechaLlegada,
        @RequestParam("pfechaSalida") Date fechaSalida,
        @RequestParam("ptipoHabitacion") String tipoHabitacion,
        @RequestParam("pcantidadSolicitada") Integer cantidadSolicitada
    ) {
        return ResponseEntity.ok(servReservacion.disponibilidad(fechaLlegada, fechaSalida, tipoHabitacion, cantidadSolicitada));
    }
	
	@PutMapping("reservas/newReserva/{pfecha_llegada}/{nombrep}/{ap_patp}/{ap_matp}/{telefonop}/{rfcp}/{emailp}/{direccionp}")
	public ResponseEntity<Integer> newReserva(
		@RequestParam("pfecha_llegada") Date fechaLlegada,
		@RequestParam("nombrep") String nombreCliente,
		@RequestParam("ap_patp") String apPaterno,
		@RequestParam("ap_matp") String apMaterno,
		@RequestParam("telefonop") String telefonoCli,
		@RequestParam("rfcp") String rfcCli,
		@RequestParam("emailp") String email,
		@RequestParam("direccionp") String direccion
    ){
        return ResponseEntity.ok(servReservacion.nuevaReserva(fechaLlegada, nombreCliente, apPaterno, apMaterno, telefonoCli, rfcCli, email, direccion));
    }
}
