package com.metodos.formales.trafficLight.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.trafficLight.model.TrafficLightEntity;

@Repository
public interface TrafficLightDao extends PagingAndSortingRepository<TrafficLightEntity, Long>{
	
	public TrafficLightEntity findById(long id);

}
