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

}
