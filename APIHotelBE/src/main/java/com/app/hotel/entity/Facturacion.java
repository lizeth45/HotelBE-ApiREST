package com.app.hotel.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturacion")
public class Facturacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private int idFactura;

	@Column(name="fecha_fact", columnDefinition="date")
	private Date fechaFactura;

	@Column(name="monto", columnDefinition="numeric(10,2)")
	private Double montoFactura;

	// Relacion hacia la tabla de facturacion <-> estancia
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_estancia", referencedColumnName = "id_estancia")
	private Estancia estancia;

	public Facturacion(Date fechaFactura, Double montoFactura, Estancia estancia) {
		super();
		this.fechaFactura = fechaFactura;
		this.montoFactura = montoFactura;
		this.estancia = estancia;
	}

	public Facturacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Double getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(Double montoFactura) {
		this.montoFactura = montoFactura;
	}

	public Estancia getEstancia() {
		return estancia;
	}

	public void setEstancia(Estancia estancia) {
		this.estancia = estancia;
	}


}
