package com.app.hotel.dto;

import java.sql.Date;

public class NewReservacionPL {
	
	private Date fechaLlegada;
	private String nombreCliente;
	private String apPaterno;
	private String apMaterno;
	private String telefonoCli;
	private String rfcCli;
	private String email;
	private String direccion;
	
	
	
	
	public NewReservacionPL() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewReservacionPL(Date fechaLlegada, String nombreCliente, String apPaterno, String apMaterno,
			String telefonoCli, String rfcCli, String email, String direccion) {
		super();
		this.fechaLlegada = fechaLlegada;
		this.nombreCliente = nombreCliente;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telefonoCli = telefonoCli;
		this.rfcCli = rfcCli;
		this.email = email;
		this.direccion = direccion;
	}
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getTelefonoCli() {
		return telefonoCli;
	}
	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}
	public String getRfcCli() {
		return rfcCli;
	}
	public void setRfcCli(String rfcCli) {
		this.rfcCli = rfcCli;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
