package com.app.hotel.dto;

public class ReservasPendientesData {

	 int idReserva;
	 String estadoReserv;
	 String nomCliente;
	 String apPatCliente;
	 String apMatCliente;
	 long cantHabitacionesdReserv;
	
	public ReservasPendientesData(int idReserva, String estadoReserv, String nomCliente, String apPatCliente,
			String apMatCliente, long cantHabitacionesdReserv) {
		super();
		this.idReserva = idReserva;
		this.estadoReserv = estadoReserv;
		this.nomCliente = nomCliente;
		this.apPatCliente = apPatCliente;
		this.apMatCliente = apMatCliente;
		this.cantHabitacionesdReserv = cantHabitacionesdReserv;
	}
	

	public ReservasPendientesData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getEstadoReserv() {
		return estadoReserv;
	}

	public void setEstadoReserv(String estadoReserv) {
		this.estadoReserv = estadoReserv;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getApPatCliente() {
		return apPatCliente;
	}

	public void setApPatCliente(String apPatCliente) {
		this.apPatCliente = apPatCliente;
	}

	public String getApMatCliente() {
		return apMatCliente;
	}

	public void setApMatCliente(String apMatCliente) {
		this.apMatCliente = apMatCliente;
	}

	public long getCantHabitacionesdReserv() {
		return cantHabitacionesdReserv;
	}

	public void setCantHabitacionesdReserv(long cantHabitacionesdReserv) {
		this.cantHabitacionesdReserv = cantHabitacionesdReserv;
	}
	
	
}
