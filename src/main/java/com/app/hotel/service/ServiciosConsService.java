package com.app.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.ServiciosCons;
import com.app.hotel.jpa.IServiciosCons;

@Service
public class ServiciosConsService implements IServiciosConsService{

	@Autowired
	private IServiciosCons repoServCons;
	
	@Override
	public List<ServiciosCons> consultaGral(){
		return repoServCons.findAll();
	}
	
	@Override
	public Integer agregarServiciosEstancia(int idEstancia, String desc_servicio) {
		return repoServCons.agregarServiciosEstancia(idEstancia, desc_servicio, null);
	}
	
}
