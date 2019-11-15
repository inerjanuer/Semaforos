package com.metodos.formales.sensor.dto;

import java.io.Serializable;

import com.metodos.formales.system.dto.SystemDto;

public class SensorDto implements Serializable {

	private static final long serialVersionUID = -8370956343951432824L;

	private long id;

	private SystemDto status;

	private SystemDto typeSensor;

	private String ref;

	public SensorDto() {
	}

	public SensorDto(long id, SystemDto status, SystemDto typeSensor, String ref) {
		this.id = id;
		this.status = status;
		this.typeSensor = typeSensor;
		this.ref = ref;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SystemDto getStatus() {
		return status;
	}

	public void setStatus(SystemDto status) {
		this.status = status;
	}

	public SystemDto getTypeSensor() {
		return typeSensor;
	}

	public void setTypeSensor(SystemDto typeSensor) {
		this.typeSensor = typeSensor;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
