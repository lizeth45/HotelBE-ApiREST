package com.app.hotel.service;

import java.util.List;

import com.app.hotel.entity.ServiciosCons;

public interface IServiciosConsService {

	List <ServiciosCons> consultaGral();

	Integer agregarServiciosEstancia(int idEstancia, String desc_servicio);

}
