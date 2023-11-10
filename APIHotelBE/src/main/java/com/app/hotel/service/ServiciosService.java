package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Servicio;
import com.app.hotel.jpa.IServicio;

@Service
public class ServiciosService implements IServiciosService {

	@Autowired
	private IServicio repoServicio;
	
	@Override
	public List<Servicio> consultaGral(){
		return repoServicio.findAll();
	}
	//AQUI
	@Override
	public List<Servicio> consultaServicioId(int idServicio){
		return repoServicio.buscarPorId(idServicio);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> insertarServicio(Servicio obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Servicio registrado correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoServicio.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> updateServicio(Servicio obj, int idServicio){
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Servicio actualizado correctamente");
		okResponse.put("status", HttpStatus.OK.toString());
    
		Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "No existe un servicio con el Id: " + idServicio);
			errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoServicio.findById(idServicio).map( p -> {				
				obj.setIdServicio(idServicio);	
				repoServicio.save(obj); 
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	@Override
	public ResponseEntity<Map<String, String>> eliminarServicio(int idServicio) {		

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "El servicio no fue encontrado");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> okResponse = new HashMap<>();
	    okResponse.put("message", "El servicio fue eliminado correctamente");
	    okResponse.put("status", HttpStatus.OK.toString());
	    
		return repoServicio.findById(idServicio).map( p -> {
					repoServicio.deleteById(idServicio);
					return new ResponseEntity<>(okResponse, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}
}
