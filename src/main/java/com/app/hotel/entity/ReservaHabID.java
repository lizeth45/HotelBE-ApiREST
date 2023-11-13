package com.app.hotel.entity;

import java.io.Serializable;



public class ReservaHabID implements Serializable {
	private int cnsReserva;
	private int idReservacion;

	public ReservaHabID(int cnsReserva, int idReservacion) {
		super();
		this.cnsReserva = cnsReserva;
		this.idReservacion = idReservacion;
	}

	public ReservaHabID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCnsReserva() {
		return cnsReserva;
	}

	public void setCnsReserva(int cnsReserva) {
		this.cnsReserva = cnsReserva;
	}

	public int getIdReservacion() {
		return idReservacion;
	}

	public void setIdReservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}
	
	
	

}
