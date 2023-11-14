package com.app.hotel.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.dto.NewReservacionPL;
import com.app.hotel.dto.ReservacionesPendDia;
import com.app.hotel.entity.Reservacion;
import com.app.hotel.service.IReservacionService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ReservacionController {

	
	@Autowired 
	private IReservacionService servReservacion;
	
	@GetMapping("/reservas")
	public List<Reservacion> showAll(){
		return servReservacion.consultaGralReservacion();
	}
	
	@GetMapping("/reservas/disponibilidad/{idthab}/{fechaSal}/{fechaLlegada}")
	public Integer disponibilidad(@PathVariable("fechaLlegada") Date fechaLlegada,
			@PathVariable("fechaSal") Date fechaSalida,
			@PathVariable("idthab") int tipoHabitacion) {
		return servReservacion.disponibilidad(tipoHabitacion, fechaSalida, fechaLlegada);
		
	}
	
	@GetMapping("/reservas/pendientesdDia")
	public List<ReservacionesPendDia> obtenerReservasPendientesHoy(){
		return servReservacion.obtenerReservasPendientesHoy();
	}
	
	@GetMapping("/reservas/verificar-disponibilidad/{pfechaLlegada}/{pfechaSalida}/{ptipoHabitacion}/{pcantidadSolicitada}")
	public ResponseEntity<Integer> verificarDisponibilidad(
			@PathVariable("pfechaLlegada") Date fechaLlegada,
			@PathVariable("pfechaSalida") Date fechaSalida,
			@PathVariable("ptipoHabitacion") String tipoHabitacion,
			@PathVariable("pcantidadSolicitada") Integer cantidadSolicitada
    ) {
        return ResponseEntity.ok(servReservacion.disponibilidad(fechaLlegada, fechaSalida, tipoHabitacion, cantidadSolicitada));
    }
	
	@PostMapping("/reservas/newReserva")
	public ResponseEntity<Integer> newReserva(@RequestBody NewReservacionPL obj ){
        return ResponseEntity.ok(servReservacion.nuevaReserva(obj.getFechaLlegada(), obj.getNombreCliente(), obj.getApPaterno(), obj.getApMaterno(), obj.getTelefonoCli(), obj.getRfcCli(), obj.getEmail(), obj.getDireccion()));
    }
	
	@PutMapping("/reservas/actEstado/{idReserva}")
	public ResponseEntity<Integer> newReserva(@PathVariable int idReservacion ){
		return ResponseEntity.ok(servReservacion.actualizarEstadoReservacion(idReservacion));
	}
}
