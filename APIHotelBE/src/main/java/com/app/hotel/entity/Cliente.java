package com.app.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int idCliente;

	@Column(name = "nombre", columnDefinition = "varchar(50) NOT NULL")
	private String nombreCliente;

	@Column(name = "appat", columnDefinition = "varchar(20)")
	private String ap_pat;

	@Column(name = "apmat", columnDefinition = "varchar(20)")
	private String ap_mat;

	@Column(name = "telefono", columnDefinition = "varchar(15)")
	private String celular;

	@Column(name = "rfc")
	private String rfc;

	@Column(name = "email")
	private String correo;

	@Column(name = "direccion")
	private String direccion;

	public Cliente(String nombreCliente, String ap_pat, String ap_mat, String celular, String rfc,
			String correo, String direccion) {
		super();
		this.nombreCliente = nombreCliente;
		this.ap_pat = ap_pat;
		this.ap_mat = ap_mat;
		this.celular = celular;
		this.rfc = rfc;
		this.correo = correo;
		this.direccion = direccion;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getAp_pat() {
		return ap_pat;
	}

	public void setAp_pat(String ap_pat) {
		this.ap_pat = ap_pat;
	}

	public String getAp_mat() {
		return ap_mat;
	}

	public void setAp_mat(String ap_mat) {
		this.ap_mat = ap_mat;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


}
