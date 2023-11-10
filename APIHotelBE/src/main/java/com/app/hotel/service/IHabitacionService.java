package com.app.hotel.service;

import java.util.List;

import com.app.hotel.entity.Habitacion;

public interface IHabitacionService {

	List<Habitacion> consultaGral();

	List<Habitacion> consultaHabitacionId(int idHabitacion);

}
