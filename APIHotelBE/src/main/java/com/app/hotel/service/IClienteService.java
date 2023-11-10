package com.app.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.hotel.entity.Cliente;

public interface IClienteService {

	List<Cliente> consultaGral();

	ResponseEntity<Map<String, String>> insertarCliente(Cliente obj);

	ResponseEntity<Map<String, String>> updateCliente(Cliente obj, int idCliente);

	ResponseEntity<Map<String, String>> eliminarCliente(int idCliente);


	List<Cliente> consultaClienteId(int idCliente);

}
