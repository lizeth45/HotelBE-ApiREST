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

import com.app.hotel.entity.Facturacion;
import com.app.hotel.service.IFacturacionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotelbe")
public class FacturacionController {
	
	@Autowired 
	private IFacturacionService servFactura;
	

	@GetMapping("/factura")
	public List<Facturacion> showAllFacturas(){  
		return servFactura.consultaGral();
	}
	
	@GetMapping("/factura/{id}")
	public List<Facturacion> showFacturaID( @PathVariable("id")int idFact)
	{
		return servFactura.consultaFacturacionId(idFact);
	}
	
	@PostMapping("/factura/finEstancia/{idEstancia}")
	public String facturar_finalizarestancia(@PathVariable("idEstancia") int idEstancia) {
		return servFactura.facturar_finalEstancia(idEstancia);
	}
	
	@PostMapping("/factura")
	public String insertarFactura(@RequestBody Facturacion obj){
		servFactura.insertarFact(obj);
		return "Cliente registrado correctamente";
	}
	
	@PutMapping("/factura/{id}")
	public ResponseEntity<Map<String, String>> actFactura(@RequestBody Facturacion obj, @PathVariable("id") int idFactura){
		return servFactura.updateFact(obj, idFactura);
	}
	
	@DeleteMapping("/factura/{id}")
	public ResponseEntity<Map<String,String>> eliminarFact(@PathVariable("id") int idFact){
		return servFactura.eliminarFact(idFact);
	}

}
