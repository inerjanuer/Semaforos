package com.metodos.formales.roles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.roles.dao.RolesDao;
import com.metodos.formales.roles.entity.RolesEntity;

@Service
@Transactional(readOnly = true)
public class RolesService {

	@Autowired
	private RolesDao repository;

	public RolesService(RolesDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public RolesEntity save(RolesEntity entity) {
		return this.repository.save(entity);
	}
	
	@Transactional
	public void delete(RolesEntity entity) {
		this.repository.delete(entity);
	}
	
	public RolesEntity findById(long id) {
		return this.repository.findById(id);
	}
	
	public List<RolesEntity> findAll() {
		return this.repository.findAll();
	}

}
