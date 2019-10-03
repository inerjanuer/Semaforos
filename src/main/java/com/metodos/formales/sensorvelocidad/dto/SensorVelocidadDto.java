package com.metodos.formales.sensorvelocidad.dto;

import java.io.Serializable;

public class SensorVelocidadDto implements Serializable {

	private static final long serialVersionUID = -8783238007276472130L;

	private long id;

	private String datos;

	public SensorVelocidadDto() {
	}

	public SensorVelocidadDto(long id, String datos) {
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
