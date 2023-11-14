package com.app.hotel.dto;

import java.sql.Date;

public class NewReservaHabPL {

	private Date fechaLlegada;
	private Date fechaSalida;
	private String tipoHab;
	public NewReservaHabPL() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewReservaHabPL(Date fechaLlegada, Date fechaSalida, String tipoHab) {
		super();
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
	}
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTipoHab() {
		return tipoHab;
	}
	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}
	
	
	
}
