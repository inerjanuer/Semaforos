package com.metodos.formales.sensor.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.sensor.model.SensorEntity;

@Repository
public interface SensorDao extends PagingAndSortingRepository<SensorEntity, Long>{

	public SensorEntity findById(long id);
	
}
