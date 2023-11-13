package com.app.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private int idEmpleado;
	
	@Column(name = "nombre_emp")
	private String nombreEmpleado;
	
	@Column(name = "user_emp")
	private String userEmpleado;
	
	@Column(name = "pass_emp")
	private String passEmpleado;
	
	@Column(name = "cargo")
	private int cargoRol;
	
	public Empleado(String nombreEmpleado, String userEmpleado, String passEmpleado, int cargoRol) {
		super();
		this.nombreEmpleado = nombreEmpleado;
		this.userEmpleado = userEmpleado;
		this.passEmpleado = passEmpleado;
		this.cargoRol = cargoRol;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getUserEmpleado() {
		return userEmpleado;
	}

	public void setUserEmpleado(String userEmpleado) {
		this.userEmpleado = userEmpleado;
	}

	public String getPassEmpleado() {
		return passEmpleado;
	}

	public void setPassEmpleado(String passEmpleado) {
		this.passEmpleado = passEmpleado;
	}

	public int getCargoRol() {
		return cargoRol;
	}

	public void setCargoRol(int cargoRol) {
		this.cargoRol = cargoRol;
	}
	
	
}
