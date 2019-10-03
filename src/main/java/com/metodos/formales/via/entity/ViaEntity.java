package com.metodos.formales.via.entity;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "via")
public class ViaEntity implements Serializable{

	private static final long serialVersionUID = -4361088577693063431L;

	@Id
	@Column(name = "id_via")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String calle;

	private String carrera;

	private String latitud;

	private String longitud;

	private String estado;

	public ViaEntity() {
	}

	public ViaEntity(long id, String calle, String carrera, String latitud, String longitud, String estado) {
		this.id = id;
		this.calle = calle;
		this.carrera = carrera;
		this.latitud = latitud;
		this.longitud = longitud;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
