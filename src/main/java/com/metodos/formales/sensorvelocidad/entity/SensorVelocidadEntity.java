package com.metodos.formales.sensorvelocidad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensor_velocidad")
public class SensorVelocidadEntity implements Serializable{

	private static final long serialVersionUID = -2768841034361262750L;

	@Id
	@Column(name="id_sensor_velocidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String datos;

	public SensorVelocidadEntity() {
	}

	public SensorVelocidadEntity(long id, String datos) {
		this.id = id;
		this.datos = datos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}
	
	
}
