package com.app.hotel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.entity.Cliente;
import com.app.hotel.service.IClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class ClienteController {
	
	@Autowired 
	private IClienteService servCliente;
	
	//Muestra TODOS los clientes
	@GetMapping("/cliente")
	public List<Cliente> showAllClientes(){  
		return servCliente.consultaGral();
	}
	
	@GetMapping("/cliente/{tel}")
	public List<Cliente> showClienteTel( @PathVariable("tel")String telefono)
	{
		return servCliente.consultaClienteTel(telefono);
	}
	
	
	//AGREGAR un cliente
	@PostMapping("/cliente")
	public String insertarCliente(@RequestBody Cliente objCliente){
		servCliente.insertarCliente(objCliente);
		return "Cliente registrado correctamente";
	}
	
	//ACTUALIZAR un cliente por el id
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Map<String, String>> actCliente(@RequestBody Cliente obj, @PathVariable("id") int idCliente){
		return servCliente.updateCliente(obj, idCliente);
	}
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Map<String,String>> eliminarCliente(@PathVariable("id") int idCliente){
		return servCliente.eliminarCliente(idCliente);
	}
}
