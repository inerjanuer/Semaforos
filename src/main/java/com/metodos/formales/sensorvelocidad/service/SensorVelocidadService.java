package com.metodos.formales.sensorvelocidad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.sensorvelocidad.dao.SensorVelocidadDao;
import com.metodos.formales.sensorvelocidad.entity.SensorVelocidadEntity;

@Service
@Transactional(readOnly = true)
public class SensorVelocidadService {

	@Autowired
	private SensorVelocidadDao repository;

	public SensorVelocidadService(SensorVelocidadDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public SensorVelocidadEntity save(SensorVelocidadEntity entity) {
		return this.repository.save(entity);
	}
	
	@Transactional
	public void delete(SensorVelocidadEntity entity) {
		this.repository.delete(entity);
	}
	
	public List<SensorVelocidadEntity> findAll(){
		return this.repository.findAll();
	}
	
	public SensorVelocidadEntity findById(long id) {
		return this.repository.findById(id);
	}
}
