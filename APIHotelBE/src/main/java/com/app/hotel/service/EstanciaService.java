package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Estancia;
import com.app.hotel.jpa.IEstancia;

@Service
public class EstanciaService implements IEstanciaService{

	@Autowired
	private IEstancia repoEstancia;
	
	@Override
	public List<Estancia> consultaGral(){
		return repoEstancia.findAll();
	}
	
	@Override
	public List<Estancia> consultaEstanciaId(int idEstancia){
		return repoEstancia.buscarPorId(idEstancia);
	}
	
	//Insertar una nueva estancia(pl)
	
	@Override
	public ResponseEntity<Map<String, String>> eliminarEstancia(int idEstancia) {		

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "La estancia no fue encontrada");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> okResponse = new HashMap<>();
	    okResponse.put("message", "La estancia fue eliminada correctamente");
	    okResponse.put("status", HttpStatus.OK.toString());
	    
		return repoEstancia.findById(idEstancia).map( p -> {
					repoEstancia.deleteById(idEstancia);
					return new ResponseEntity<>(okResponse, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}
	
}
