package com.app.hotel.entity;

import java.io.Serializable;

public class ServiciosConsID implements Serializable {

	private int idServcons;
	private int idEstancia;
	public ServiciosConsID(int idServcons, int idEstancia) {
		super();
		this.idServcons = idServcons;
		this.idEstancia = idEstancia;
	}
	
	
	public ServiciosConsID() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdServcons() {
		return idServcons;
	}
	public void setIdServcons(int idServcons) {
		this.idServcons = idServcons;
	}
	public int getIdEstancia() {
		return idEstancia;
	}
	public void setIdEstancia(int idEstancia) {
		this.idEstancia = idEstancia;
	}


}
