package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.Habitacion;

public interface IHabitacionService {

	List<Habitacion> consultaGral();

	List<Habitacion> consultaHabitacionId(int idHabitacion);

	ResponseEntity<Map<String, String>> insertarHabitacion(Habitacion obj);

	ResponseEntity<Map<String, String>> updateHabitacion(Habitacion obj, int idHab);

	ResponseEntity<Map<String, String>> eliminarHab(int idHab);

}
