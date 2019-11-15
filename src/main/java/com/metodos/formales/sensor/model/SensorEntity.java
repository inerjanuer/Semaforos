package com.metodos.formales.sensor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.metodos.formales.system.model.SystemEntity;

@Entity
@Table(name = "sensor")
public class SensorEntity implements Serializable {

	private static final long serialVersionUID = -2452794166029286005L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private SystemEntity status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_sensor")
	private SystemEntity typeSensor;

	private String ref;

	public SensorEntity() {
	}

	public SensorEntity(long id, SystemEntity status, SystemEntity typeSensor, String ref) {
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

	public SystemEntity getStatus() {
		return status;
	}

	public void setStatus(SystemEntity status) {
		this.status = status;
	}

	public SystemEntity getTypeSensor() {
		return typeSensor;
	}

	public void setTypeSensor(SystemEntity typeSensor) {
		this.typeSensor = typeSensor;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
