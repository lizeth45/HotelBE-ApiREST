package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.Empleado;

public interface IEmpleadoService {

	List<Empleado> showAllEmpleados();

	List<Empleado> consultaEmpleadoLogin(String user, String pass);

	ResponseEntity<Map<String, String>> insertarEmpleado(Empleado obj);

}
