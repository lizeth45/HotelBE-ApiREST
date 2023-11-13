package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Facturacion;
import com.app.hotel.jpa.IFacturacionjpa;

@Service
public class FacturacionService implements IFacturacionService{

	@Autowired
	private IFacturacionjpa repoFacturacion;
	
	@Override
	public List<Facturacion> consultaGral(){
		return repoFacturacion.findAll();
	}
	
	@Override
	public List<Facturacion> consultaFacturacionId(int idFact){
		return repoFacturacion.buscarPorId(idFact);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> insertarFact(Facturacion obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Facturacion registrada correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoFacturacion.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> updateFact(Facturacion obj, int idFact){
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Facturacion actualizada correctamente");
		okResponse.put("status", HttpStatus.OK.toString());
    
		Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "No existe una facturacion con el Id: " + idFact);
			errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoFacturacion.findById(idFact).map( p -> {				
				obj.setIdFactura(idFact);
				repoFacturacion.save(obj); 
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	@Override
	public ResponseEntity<Map<String, String>> eliminarFact(int idFact) {		

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "La factura no fue encontrada");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> okResponse = new HashMap<>();
	    okResponse.put("message", "La facturacion fue eliminada correctamente");
	    okResponse.put("status", HttpStatus.OK.toString());
	    
		return repoFacturacion.findById(idFact).map( p -> {
					repoFacturacion.deleteById(idFact);
					return new ResponseEntity<>(okResponse, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}
}
