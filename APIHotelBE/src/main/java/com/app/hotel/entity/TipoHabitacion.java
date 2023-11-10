package com.app.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_hab")
public class TipoHabitacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_thab")
	private int idTHabitacion;

	@Column(name="desc_hab")
	private String descripcionHab;

	@Column(name = "cant_camas")
	private int cantCamas;

	@Column(name = "cant_personas")
	private int cantPersonas;

	@Column(name = "precio_hab", columnDefinition = "numeric(4,2)")
	private Double precioHabitacion;

	public TipoHabitacion(String descripcionHab, int cantCamas, int cantPersonas, Double precioHabitacion) {
		super();
		this.descripcionHab = descripcionHab;
		this.cantCamas = cantCamas;
		this.cantPersonas = cantPersonas;
		this.precioHabitacion = precioHabitacion;
	}

	public TipoHabitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTHabitacion() {
		return idTHabitacion;
	}

	public void setIdTHabitacion(int idTHabitacion) {
		this.idTHabitacion = idTHabitacion;
	}

	public String getDescripcionHab() {
		return descripcionHab;
	}

	public void setDescripcionHab(String descripcionHab) {
		this.descripcionHab = descripcionHab;
	}

	public int getCantCamas() {
		return cantCamas;
	}

	public void setCantCamas(int cantCamas) {
		this.cantCamas = cantCamas;
	}

	public int getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}

	public Double getPrecioHabitacion() {
		return precioHabitacion;
	}

	public void setPrecioHabitacion(Double precioHabitacion) {
		this.precioHabitacion = precioHabitacion;
	}


}
