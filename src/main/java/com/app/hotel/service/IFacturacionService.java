package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.Facturacion;

public interface IFacturacionService {

	ResponseEntity<Map<String, String>> eliminarFact(int idFact);

	ResponseEntity<Map<String, String>> updateFact(Facturacion obj, int idFact);

	ResponseEntity<Map<String, String>> insertarFact(Facturacion obj);

	List<Facturacion> consultaGral();

	List<Facturacion> consultaFacturacionId(int idFact);

}
