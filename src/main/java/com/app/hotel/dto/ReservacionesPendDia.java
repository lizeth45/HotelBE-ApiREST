package com.app.hotel.dto;

public class ReservacionesPendDia {

	private int idReserva;
	private String nomCliente;
	private String telCliente;
	private String emailCliente;
	public ReservacionesPendDia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservacionesPendDia(int idReserva, String nomCliente, String telCliente, String emailCliente) {
		super();
		this.idReserva = idReserva;
		this.nomCliente = nomCliente;
		this.telCliente = telCliente;
		this.emailCliente = emailCliente;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getTelCliente() {
		return telCliente;
	}
	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	
}
