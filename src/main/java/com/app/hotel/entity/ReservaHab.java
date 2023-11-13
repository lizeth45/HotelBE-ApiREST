package com.app.hotel.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva_hab")
@IdClass(ReservaHabID.class)
public class ReservaHab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cns_reserva")
	private int cnsReserva;

	@Id
	@Column(name="id_reserva")
	private int idReservacion;

	@Column(name="fecha_reserva", columnDefinition = "date DEFAULT CURRENT_DATE")
	private Date fechaReserva;

	@Column(name="hora_reserva", columnDefinition = "time DEFAULT CURRENT_TIME")
	private Time horaReserva;

	@Column(name="fecha_llegada", columnDefinition = "date CHECK (fecha_llegada >= CURRENT_DATE)")
	private Date fechaLlegada;

	@Column(name="fecha_salida", columnDefinition = "date CHECK (fecha_salida > fecha_llegada)")
	private Date fechaSalida;

	// Relacion hacia la tabla de habitacion <- reservaHab
	@ManyToOne
	@JoinColumn(name = "id_hab", referencedColumnName = "id_hab")
	private Habitacion habitacion;


	//Relacion con su entidad fuerte reservacion <= reservaHab
	@ManyToOne
    @MapsId("idReservacion") //Entity Class
    @JoinColumn(name = "id_reserva")  //BD
    private Reservacion reservacion;


	public ReservaHab(Date fechaReserva, Time horaReserva, Date fechaLlegada, Date fechaSalida, Habitacion habitacion,
			Reservacion reservacion) {
		super();
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.habitacion = habitacion;
		this.reservacion = reservacion;
	}


	public ReservaHab() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Date getFechaReserva() {
		return fechaReserva;
	}

	public int getCnsReserva() {
		return cnsReserva;
	}


	public void setCnsReserva(int cnsReserva) {
		this.cnsReserva = cnsReserva;
	}


	public int getIdReservacion() {
		return idReservacion;
	}


	public void setIdReservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}


	public Reservacion getReservacion() {
		return reservacion;
	}


	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}


	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


	public Time getHoraReserva() {
		return horaReserva;
	}


	public void setHoraReserva(Time horaReserva) {
		this.horaReserva = horaReserva;
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


	public Habitacion getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

}
