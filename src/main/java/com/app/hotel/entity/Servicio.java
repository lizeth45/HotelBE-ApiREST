package com.app.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_servicio")
	private int idServicio;

	@Column(name="desc_servicio")
	private String descServicio;

	@Column(name="precio_servicio")
	private float precioServicio;

	public Servicio(String descServicio, float precioServicio) {
		super();
		this.descServicio = descServicio;
		this.precioServicio = precioServicio;
	}

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescServicio() {
		return descServicio;
	}

	public void setDescServicio(String descServicio) {
		this.descServicio = descServicio;
	}

	public float getPrecioServicio() {
		return precioServicio;
	}

	public void setPrecioServicio(float precioServicio) {
		this.precioServicio = precioServicio;
	}

}
