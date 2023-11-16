package com.app.hotel.service;

import java.util.List;

import com.app.hotel.entity.Cancelacion;

public interface ICancelacionService {

	List<Cancelacion> consultaGral();

	List<Cancelacion> consultaCancelacionId(int idCancelacion);

	String insertCancelacion(int idReserva, String motivo);

}
