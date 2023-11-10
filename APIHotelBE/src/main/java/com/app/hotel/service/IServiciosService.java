package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.Servicio;

public interface IServiciosService {

	List<Servicio> consultaGral();

	List<Servicio> consultaServicioId(int idServicio);

	ResponseEntity<Map<String, String>> eliminarServicio(int idServicio);

	ResponseEntity<Map<String, String>> updateServicio(Servicio obj, int idServicio);

	ResponseEntity<Map<String, String>> insertarServicio(Servicio obj);

}
