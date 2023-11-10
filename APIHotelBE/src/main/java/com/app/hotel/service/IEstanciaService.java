package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.Estancia;

public interface IEstanciaService {

	List<Estancia> consultaGral();

	List<Estancia> consultaEstanciaId(int idEstancia);

	ResponseEntity<Map<String, String>> eliminarEstancia(int idEstancia);

}
