package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Cliente;
import com.app.hotel.jpa.IClientejpa;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private IClientejpa repoCliente;
	
	@Override
	public List<Cliente> consultaGral(){
		return repoCliente.findAll();
	}
	
	@Override
	public List<Cliente> consultaClienteId(int idCliente){
		return repoCliente.buscarPorId(idCliente);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> insertarCliente(Cliente obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Cliente registrado correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoCliente.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> updateCliente(Cliente obj, int idCliente){
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Cliente actualizado correctamente");
		okResponse.put("status", HttpStatus.OK.toString());
    
		Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "No existe un cliente con el Id: " + idCliente);
			errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoCliente.findById(idCliente).map( p -> {				
				obj.setIdCliente(idCliente);	
				repoCliente.save(obj); 
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	@Override
	public ResponseEntity<Map<String, String>> eliminarCliente(int idCliente) {		

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "El cliente no fue encontrado");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> okResponse = new HashMap<>();
	    okResponse.put("message", "El cliente fue eliminado correctamente");
	    okResponse.put("status", HttpStatus.OK.toString());
	    
		return repoCliente.findById(idCliente).map( p -> {
					repoCliente.deleteById(idCliente);
					return new ResponseEntity<>(okResponse, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}

}
