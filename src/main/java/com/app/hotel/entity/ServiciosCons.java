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
@Table(name = "servicios_cons")
@IdClass(ServiciosConsID.class)
public class ServiciosCons {

	@Id
	@Column(name="id_servcons")
	private int idServcons;

	@Id
	@Column(name = "id_estancia")
	private int idEstancia;

	@Column(name="hora")
	private Time horaServcons;

	@Column(name="dia")
	private Date diaServcons;

	@Column(name="monto")
	private float montoServcons;

	//Relacion con entidad servicio<-serviciosCons
	@ManyToOne
	@JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
	private Servicio servicio;

	//Relacion con su entidad fuerte estancia <= servicios_cons
	@ManyToOne
    @MapsId("idEstancia") //Entity Class
    @JoinColumn(name = "id_estancia")  //BD
    private Estancia estancia;

	public ServiciosCons(Time horaServcons, Date diaServcons, float montoServcons, Servicio servicio,
			Estancia estancia) {
		super();
		this.horaServcons = horaServcons;
		this.diaServcons = diaServcons;
		this.montoServcons = montoServcons;
		this.servicio = servicio;
		this.estancia = estancia;
	}

	public ServiciosCons() {
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

	public Time getHoraServcons() {
		return horaServcons;
	}

	public void setHoraServcons(Time horaServcons) {
		this.horaServcons = horaServcons;
	}

	public Date getDiaServcons() {
		return diaServcons;
	}

	public void setDiaServcons(Date diaServcons) {
		this.diaServcons = diaServcons;
	}

	public float getMontoServcons() {
		return montoServcons;
	}

	public void setMontoServcons(float montoServcons) {
		this.montoServcons = montoServcons;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Estancia getEstancia() {
		return estancia;
	}

	public void setEstancia(Estancia estancia) {
		this.estancia = estancia;
	}



}
