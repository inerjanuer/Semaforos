package com.metodos.formales.sensortrafico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.sensortrafico.dao.SensorTraficoDao;
import com.metodos.formales.sensortrafico.entity.SensorTraficoEntity;

@Service
@Transactional(readOnly = true)
public class SensorTraficoService {

	@Autowired
	private SensorTraficoDao repository;

	public SensorTraficoService(SensorTraficoDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public void delete(SensorTraficoEntity entity) {
		this.repository.delete(entity);
	}
	
	@Transactional
	public SensorTraficoEntity save(SensorTraficoEntity entity) {
		return this.repository.save(entity);
	}
	
	public List<SensorTraficoEntity> findAll() {
		return this.repository.findAll();
	}
	
	public SensorTraficoEntity findById(long id) {
		return this.repository.findById(id);
	}
}
