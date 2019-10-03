package com.metodos.formales.semaforo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.semaforo.dao.SemaforoDao;
import com.metodos.formales.semaforo.entity.SemaforoEntity;

@Service
@Transactional(readOnly = true)
public class SemaforoService {
	
	@Autowired
	private SemaforoDao repository;

	public SemaforoService(SemaforoDao repository) {
		this.repository = repository;
	};
	
	@Transactional
	public void delete(SemaforoEntity entity) {
		this.repository.delete(entity);
	}

	@Transactional
	public SemaforoEntity save(SemaforoEntity entity) {
		return this.repository.save(entity);
	}
	
	public List<SemaforoEntity> findAll(){
		return this.repository.findAll();
	}
	
	public SemaforoEntity findById(long id) {
		return this.repository.findById(id);
	}
}
