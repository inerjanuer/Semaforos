package com.metodos.formales.semaforo.dto;

import java.io.Serializable;

import com.metodos.formales.sensortrafico.entity.SensorTraficoEntity;
import com.metodos.formales.sensorvelocidad.entity.SensorVelocidadEntity;
import com.metodos.formales.via.entity.ViaEntity;

public class SemafaroDto implements Serializable{

	private static final long serialVersionUID = 6049222658062733441L;

	private long id;

	private String latitud;

	private String longitud;

	private String estado;

	private SensorTraficoEntity sensorTrafico;

	private SensorVelocidadEntity sensorVelocidad;

	private ViaEntity via;

	public SemafaroDto() {
	}

	public SemafaroDto(long id, String latitud, String longitud, String estado, SensorTraficoEntity sensorTrafico,
			SensorVelocidadEntity sensorVelocidad, ViaEntity via) {
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.estado = estado;
		this.sensorTrafico = sensorTrafico;
		this.sensorVelocidad = sensorVelocidad;
		this.via = via;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public SensorTraficoEntity getSensorTrafico() {
		return sensorTrafico;
	}

	public void setSensorTrafico(SensorTraficoEntity sensorTrafico) {
		this.sensorTrafico = sensorTrafico;
	}

	public SensorVelocidadEntity getSensorVelocidad() {
		return sensorVelocidad;
	}

	public void setSensorVelocidad(SensorVelocidadEntity sensorVelocidad) {
		this.sensorVelocidad = sensorVelocidad;
	}

	public ViaEntity getVia() {
		return via;
	}

	public void setVia(ViaEntity via) {
		this.via = via;
	}

}
