package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.app.hotel.entity.TipoHabitacion;
import com.app.hotel.jpa.ITipoHabitacionjpa;

@Service
public class TipoHabitacionService implements ITipoHabitacionService {

	@Autowired
	private ITipoHabitacionjpa repoTipoHabitacion;
	
	@Override
	public List<TipoHabitacion> consultaGral(){
		return repoTipoHabitacion.findAll();
	}
	
	@Override
	public List<TipoHabitacion> consultaTipoHabDesc(String descTHab){
		return repoTipoHabitacion.buscarPorDescrip(descTHab);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> insertarTHab(TipoHabitacion obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Tipo de habitacion registrado correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoTipoHabitacion.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> updateTHab(TipoHabitacion obj, int idTHabitacion){
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Tipo habitacion actualizado correctamente");
		okResponse.put("status", HttpStatus.OK.toString());
    
		Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "No existe un tipo habitacion con el Id: " + idTHabitacion);
			errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoTipoHabitacion.findById(idTHabitacion).map( p -> {				
				obj.setIdTHabitacion(idTHabitacion);
				repoTipoHabitacion.save(obj); 
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	@Override
	public ResponseEntity<Map<String, String>> eliminarTHabitacion(int idTHab) {		

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "El tipo habitacion no fue encontrado");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> okResponse = new HashMap<>();
	    okResponse.put("message", "El tipo habitacion fue eliminado correctamente");
	    okResponse.put("status", HttpStatus.OK.toString());
	    
		return repoTipoHabitacion.findById(idTHab).map( p -> {
					repoTipoHabitacion.deleteById(idTHab);
					return new ResponseEntity<>(okResponse, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}
}
