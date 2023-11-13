package com.app.hotel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Empleado;
import com.app.hotel.jpa.IEmpleadojpa;

@Service
public class EmpleadoService implements IEmpleadoService{

	@Autowired 
	private IEmpleadojpa repoEmpleado;
	
	@Override
	public List<Empleado> showAllEmpleados(){
		return repoEmpleado.findAll();
	}
	
	@Override
	public List<Empleado> consultaEmpleadoLogin(String user, String pass){
		return repoEmpleado.buscarUserLogin(user, pass);
	}
	
	@Override
	public ResponseEntity<Map<String, String>> insertarEmpleado(Empleado obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Empleado registrado correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoEmpleado.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
}
