package com.app.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Habitacion;
import com.app.hotel.jpa.IHabitacionjpa;

@Service
public class HabitacionService implements IHabitacionService {

	@Autowired 
	private IHabitacionjpa repoHabitacion;
	
	@Override
	public List<Habitacion> consultaGral(){
		return repoHabitacion.findAll();
	}
	
	@Override
	public List<Habitacion> consultaHabitacionId(int idHabitacion){
		return repoHabitacion.buscarPorId(idHabitacion);
	}
	
}
