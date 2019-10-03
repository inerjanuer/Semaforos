package com.metodos.formales.semaforo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.metodos.formales.sensortrafico.entity.SensorTraficoEntity;
import com.metodos.formales.sensorvelocidad.entity.SensorVelocidadEntity;
import com.metodos.formales.via.entity.ViaEntity;

@Entity
@Table(name = "semaforo")
public class SemaforoEntity {

	@Id
	@Column(name = "id_semaforo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String latitud;

	private String longitud;

	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	private SensorTraficoEntity sensorTrafico;

	@ManyToOne(fetch = FetchType.LAZY)
	private SensorVelocidadEntity sensorVelocidad;

	@ManyToOne(fetch = FetchType.LAZY)
	private ViaEntity via;

	public SemaforoEntity() {
	}

	public SemaforoEntity(long id, String latitud, String longitud, String estado, SensorTraficoEntity sensorTrafico,
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
