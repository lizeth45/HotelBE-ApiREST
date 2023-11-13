package com.app.hotel.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservacion")
public class Reservacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReservacion;

	@Column(name = "estado", columnDefinition = "varchar DEFAULT 'PENDIENTE'")
    private String estado;

	// Relacion hacia la tabla de cliente <- reservacion
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;

	//Relacion con su detalle reservaHab => reservacion
	@OneToMany(mappedBy = "reservacion")
    private List<ReservaHab> reservaHabitacion;

	public Reservacion(String estado, Cliente cliente, List<ReservaHab> reservaHabitacion) {
		super();
		this.estado = estado;
		this.cliente = cliente;
		this.reservaHabitacion = reservaHabitacion;
	}

	public Reservacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdReservacion() {
		return idReservacion;
	}

	public void setIdReservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ReservaHab> getReservaHabitacion() {
		return reservaHabitacion;
	}

	public void setReservaHabitacion(List<ReservaHab> reservaHabitacion) {
		this.reservaHabitacion = reservaHabitacion;
	}


}
