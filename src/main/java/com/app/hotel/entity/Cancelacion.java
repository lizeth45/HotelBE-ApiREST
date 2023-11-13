package com.app.hotel.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cancelacion")
public class Cancelacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cancelacion")
	private int idCancelacion;

	@Column(name = "fecha_can")
	private Date fechaCancelacion;

	@Column(name = "hora_can")
	private Time horaCancelacion;

	@Column(name = "motivo")
	private String motivoCancelacion;

	// Relacion hacia la tabla de reservacion <- cancelacion
	@ManyToOne
	@JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
	private Reservacion reservacion;

	public Cancelacion(Date fechaCancelacion, Time horaCancelacion, String motivoCancelacion, Reservacion reservacion) {
		super();
		this.fechaCancelacion = fechaCancelacion;
		this.horaCancelacion = horaCancelacion;
		this.motivoCancelacion = motivoCancelacion;
		this.reservacion = reservacion;
	}

	public Cancelacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCancelacion() {
		return idCancelacion;
	}

	public void setIdCancelacion(int idCancelacion) {
		this.idCancelacion = idCancelacion;
	}

	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	public Time getHoraCancelacion() {
		return horaCancelacion;
	}

	public void setHoraCancelacion(Time horaCancelacion) {
		this.horaCancelacion = horaCancelacion;
	}

	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}




}
