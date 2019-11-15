package com.metodos.formales.trafficLight.dto;

import java.io.Serializable;

import com.metodos.formales.system.dto.SystemDto;

public class TrafficLightDto implements Serializable {

	private static final long serialVersionUID = 8817780161598319292L;

	private long id;

	private String latitud;

	private String longitud;

	private String time;

	private SystemDto status;

	public TrafficLightDto() {
	}

	public TrafficLightDto(long id, String latitud, String longitud, String time, SystemDto status) {
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.time = time;
		this.status = status;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public SystemDto getStatus() {
		return status;
	}

	public void setStatus(SystemDto status) {
		this.status = status;
	}

}
