package com.app.hotel.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.ReservaHab;
import com.app.hotel.jpa.IReservaHab;

@Service
public class ReservacionHabService implements IReservacionHabService{

	@Autowired 
	private IReservaHab repoReservaHab;
	
	@Override
	public List <ReservaHab> consultaGral(){
		return repoReservaHab.findAll();
	}
	
	@Override
	public Integer newReservaHab(Date fechaLlegada, Date fechaSalida, String tipoHab) {
		return repoReservaHab.procesoReservacionHab(fechaLlegada, fechaSalida, tipoHab, null);
	}
}
