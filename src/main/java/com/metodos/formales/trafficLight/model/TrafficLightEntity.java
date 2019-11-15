package com.metodos.formales.trafficLight.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.metodos.formales.system.model.SystemEntity;

@Entity
@Table(name = "traffic_light")
public class TrafficLightEntity implements Serializable {

	private static final long serialVersionUID = -8265162947113184902L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String latitud;

	private String longitud;

	private String time;

	@ManyToOne(fetch = FetchType.LAZY)
	private SystemEntity status;

	public TrafficLightEntity() {
	}

	public TrafficLightEntity(long id, String latitud, String longitud, String time, SystemEntity status) {
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

	public SystemEntity getStatus() {
		return status;
	}

	public void setStatus(SystemEntity status) {
		this.status = status;
	}

}
