package com.app.hotel.service;

import java.sql.Date;
import java.util.List;

import com.app.hotel.entity.ReservaHab;

public interface IReservacionHabService {

	String newReservaHab(Date fechaLlegada, Date fechaSalida, String tipoHab);

	List<ReservaHab> consultaGral();

}
