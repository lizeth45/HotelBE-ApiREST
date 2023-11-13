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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estancia")
public class Estancia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_estancia")
	private int idEstancia;

	@Column(name = "dias")
	private int diasEstancia;

	@Column(name = "fecha_llegada")
	private Date fechaLlegadaEstancia;

	@Column(name = "hora_llegada")
	private Time horaLlegadaEstancia;

	@Column(name = "fecha_salida", columnDefinition = "date CHECK (fecha_salida >= fecha_llegada)")
	private Date fechaSalidaEstancia;

	@Column(name = "hora_salida", columnDefinition = "time CHECK (hora_salida > hora_llegada)")
	private Time horaSalidaEstacia;

	// Relacion hacia la tabla de cliente <- estancia
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;

	// Relacion hacia la tabla de reservacion <-> estancia
	@OneToOne
	@JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
	private Reservacion reservacion;

	public Estancia(int diasEstancia, Date fechaLlegadaEstancia, Time horaLlegadaEstancia,
			Date fechaSalidaEstancia, Time horaSalidaEstacia, Cliente cliente, Reservacion reservacion) {
		super();
		this.diasEstancia = diasEstancia;
		this.fechaLlegadaEstancia = fechaLlegadaEstancia;
		this.horaLlegadaEstancia = horaLlegadaEstancia;
		this.fechaSalidaEstancia = fechaSalidaEstancia;
		this.horaSalidaEstacia = horaSalidaEstacia;
		this.cliente = cliente;
		this.reservacion = reservacion;
	}

	public Estancia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdEstancia() {
		return idEstancia;
	}

	public void setIdEstancia(int idEstancia) {
		this.idEstancia = idEstancia;
	}

	public int getDiasEstancia() {
		return diasEstancia;
	}

	public void setDiasEstancia(int diasEstancia) {
		this.diasEstancia = diasEstancia;
	}

	public Date getFechaLlegadaEstancia() {
		return fechaLlegadaEstancia;
	}

	public void setFechaLlegadaEstancia(Date fechaLlegadaEstancia) {
		this.fechaLlegadaEstancia = fechaLlegadaEstancia;
	}

	public Time getHoraLlegadaEstancia() {
		return horaLlegadaEstancia;
	}

	public void setHoraLlegadaEstancia(Time horaLlegadaEstancia) {
		this.horaLlegadaEstancia = horaLlegadaEstancia;
	}

	public Date getFechaSalidaEstancia() {
		return fechaSalidaEstancia;
	}

	public void setFechaSalidaEstancia(Date fechaSalidaEstancia) {
		this.fechaSalidaEstancia = fechaSalidaEstancia;
	}

	public Time getHoraSalidaEstacia() {
		return horaSalidaEstacia;
	}

	public void setHoraSalidaEstacia(Time horaSalidaEstacia) {
		this.horaSalidaEstacia = horaSalidaEstacia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}



}
