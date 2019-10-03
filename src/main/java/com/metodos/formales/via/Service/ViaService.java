package com.metodos.formales.via.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.via.dao.ViaDao;
import com.metodos.formales.via.entity.ViaEntity;

@Service
@Transactional(readOnly = true)
public class ViaService {

	@Autowired
	private ViaDao repository;

	public ViaService(ViaDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public ViaEntity save(ViaEntity entity) {
		return this.repository.save(entity);
	}
	
	@Transactional
	public void delete(ViaEntity entity) {
		this.repository.delete(entity);
	}
	
	public List<ViaEntity> findAll() {
		return this.repository.findAll();
	}
	
	public ViaEntity findById(long id) {
		return this.repository.findById(id);
	}
}
