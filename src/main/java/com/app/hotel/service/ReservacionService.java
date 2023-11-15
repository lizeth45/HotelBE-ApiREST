package com.app.hotel.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.entity.Reservacion;
import com.app.hotel.jpa.IReservacionjpa;

@Service
public class ReservacionService implements IReservacionService {
	
	@Autowired
	private IReservacionjpa repoReserva;
	
	@Override
	public Integer disponibilidad(Date fechaLlegada, Date fechaSalida, String tipoHabitacion, Integer cantidadSolicitada){
		return repoReserva.verificarDisponibilidad(fechaLlegada, fechaSalida, tipoHabitacion, cantidadSolicitada, null);
	}
	
	@Override
	public Integer nuevaReserva(Date fechaLlegada, String nombreCliente, String apPaterno, String apMaterno, String telefonoCli,String rfcCli, String email, String direccion){
		return repoReserva.resprocesoReservacion(fechaLlegada, nombreCliente, apPaterno, apMaterno, telefonoCli, rfcCli, email, direccion, null);
	}
	
	@Override
	public List<Reservacion> consultaGralReservacion(){
		return repoReserva.findAll();
	}
	
	@Override
	public List<Object[]> obtenerReservasPendientesHoy(){
		return repoReserva.obtenerReservasPendientesHoy();
	}
	
	@Override
	public String actualizarEstadoReservacion(int idReserva) {
		return repoReserva.actualizarEstadoReservacion(idReserva, null);
	}
	
	@Override
	public Integer disponibilidad(int idthab, Date fechSalida, Date fechLlegada) {
		return repoReserva.disponibilidad(idthab, fechSalida, fechLlegada);
	}
	
	@Override
	public Integer obtIdClienteReserva(int idReserva) {
		return repoReserva.obtIdClienteReserva(idReserva);
	}
	
	@Override
	public List<Reservacion> reservasPendientesAll(){
		return repoReserva.reservasPendientesAll();
	}
}
