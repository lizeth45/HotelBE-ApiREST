package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Habitacion;
import com.app.hotel.jpa.IHabitacionjpa;

@Service
public class HabitacionService implements IHabitacionService {

	@Autowired 
	private IHabitacionjpa repoHabitacion;
	
	@Override
	public List<Habitacion> consultaGral(){
		return repoHabitacion.findAll();
	}
	
	@Override
	public List<Habitacion> consultaHabitacionId(int idHabitacion){
		return repoHabitacion.buscarPorId(idHabitacion);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> insertarHabitacion(Habitacion obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Habitacion registrada correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoHabitacion.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	
	@Override
	public ResponseEntity<Map<String, String>> updateHabitacion(Habitacion obj, int idHab){
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Habitacion actualizada correctamente");
		okResponse.put("status", HttpStatus.OK.toString());
    
		Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "No existe una habitacion con el Id: " + idHab);
			errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoHabitacion.findById(idHab).map( p -> {				
				obj.setIdHabitacion(idHab);	
				repoHabitacion.save(obj); 
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	@Override
	public ResponseEntity<Map<String, String>> eliminarHab(int idHab) {		

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "La habitacion no fue encontrada");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> okResponse = new HashMap<>();
	    okResponse.put("message", "La habitacion fue eliminada correctamente");
	    okResponse.put("status", HttpStatus.OK.toString());
	    
		return repoHabitacion.findById(idHab).map( p -> {
					repoHabitacion.deleteById(idHab);
					return new ResponseEntity<>(okResponse, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}
	
}
