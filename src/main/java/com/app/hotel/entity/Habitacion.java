package com.app.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_hab")
	private int idHabitacion;

	@Column(name="numeroHab")
	private String numeroHabitacion;

	//Indicando relacion con tipo_hab <- habitacion
	@ManyToOne
	@JoinColumn(name = "id_thab", referencedColumnName = "id_thab")
	private TipoHabitacion tipoHab;

	public Habitacion(String numeroHabitacion, TipoHabitacion tipoHab) {
		super();
		this.numeroHabitacion = numeroHabitacion;
		this.tipoHab = tipoHab;
	}

	public Habitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public TipoHabitacion getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(TipoHabitacion tipoHab) {
		this.tipoHab = tipoHab;
	}


}
