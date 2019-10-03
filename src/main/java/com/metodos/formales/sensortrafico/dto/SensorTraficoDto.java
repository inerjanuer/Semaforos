package com.metodos.formales.sensortrafico.dto;

import java.io.Serializable;

public class SensorTraficoDto implements Serializable {

	private static final long serialVersionUID = 4331334998266380614L;

	private long id;

	private String datos;

	public SensorTraficoDto() {
	}

	public SensorTraficoDto(long id, String datos) {
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
