package com.app.hotel.service;

import java.sql.Date;
import java.util.List;

import com.app.hotel.entity.Reservacion;

public interface IReservacionService {

	Integer disponibilidad(Date fechaLlegada, Date fechaSalida, String tipoHabitacion, Integer cantidadSolicitada);

	Integer nuevaReserva(Date fechaLlegada, String nombreCliente, String apPaterno, String apMaterno,
			String telefonoCli, String rfcCli, String email, String direccion);

	List<Reservacion> consultaGralReservacion();

}
