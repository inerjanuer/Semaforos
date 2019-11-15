package com.metodos.formales.system.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.metodos.formales.system.model.SystemEntity;

public interface SystemDao extends PagingAndSortingRepository<SystemEntity, Long>{

	public SystemEntity findById(long id);
	
	public SystemEntity findByName(String name);
	
	public List<SystemEntity> findByType(String type);
}
