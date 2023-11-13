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


}
