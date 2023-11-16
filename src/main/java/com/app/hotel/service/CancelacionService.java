package com.app.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Cancelacion;
import com.app.hotel.jpa.ICancelacionjpa;

@Service
public class CancelacionService implements ICancelacionService{

	@Autowired
	private ICancelacionjpa repoCancelacion;
	
	@Override
	public List<Cancelacion> consultaGral(){
		return repoCancelacion.findAll();
	}
	
	@Override
	public String insertCancelacion(int idReserva, String motivo) {
		return repoCancelacion.procesoCancelacion(idReserva, motivo, null);
	}
	
	@Override
	public List<Cancelacion> consultaCancelacionId(int idCancelacion){
		return repoCancelacion.buscarPorId(idCancelacion);
	}
	
//	@Override
//	public ResponseEntity<Map<String, String>> insertarCancelacion(Cancelacion obj) {
//		Map<String, String> okResponse = new HashMap<>();
//		okResponse.put("message", "Cliente registrado correctamente");
//	    okResponse.put("status", HttpStatus.CREATED.toString());
//	    repoCancelacion.save(obj);
//		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
//	}
}
