package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.TipoHabitacion;

public interface ITipoHabitacionService {

	List<TipoHabitacion> consultaGral();

	ResponseEntity<Map<String, String>> insertarTHab(TipoHabitacion obj);

	ResponseEntity<Map<String, String>> eliminarTHabitacion(int idTHab);

	ResponseEntity<Map<String, String>> updateTHab(TipoHabitacion obj, int idTHabitacion);


	List<TipoHabitacion> consultaTipoHabDesc(String descTHab);

}
