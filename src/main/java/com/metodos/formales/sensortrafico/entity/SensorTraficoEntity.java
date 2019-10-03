package com.metodos.formales.sensortrafico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_trafico")
public class SensorTraficoEntity implements Serializable {

	private static final long serialVersionUID = -2673111759029475828L;

	@Id
	@Column(name = "id_sensor_trafico")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String datos;

	public SensorTraficoEntity() {
	}

	public SensorTraficoEntity(long id, String datos) {
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
