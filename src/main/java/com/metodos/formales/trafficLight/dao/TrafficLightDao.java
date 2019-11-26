package com.metodos.formales.trafficLight.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import com.metodos.formales.trafficLight.model.TrafficLightEntity;

@Repository
public interface TrafficLightDao extends PagingAndSortingRepository<TrafficLightEntity, Long>{
	
	public TrafficLightEntity findById(long id);
	
	public List<TrafficLightEntity> findByCallecarre(boolean value);

}
