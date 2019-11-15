package com.metodos.formales.trafficLight.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodos.formales.trafficLight.dao.TrafficLightDao;
import com.metodos.formales.trafficLight.dto.TrafficLightDto;
import com.metodos.formales.trafficLight.model.TrafficLightEntity;

@Service
public class TrafficLightService {

	@Autowired
	private TrafficLightDao repository;
	
	static ModelMapper modelMapper = new ModelMapper();

	public TrafficLightService(TrafficLightDao repository) {
		this.repository = repository;
	}
	public TrafficLightDto findById(long id) {
		return convertEntityToDto(this.repository.findById(id));
	}
	
	@Transactional
	public TrafficLightDto save(TrafficLightDto dto) {
		TrafficLightEntity entity = convertDtoToEntity(dto);
		return convertEntityToDto(this.repository.save(entity));
	}
	
	@Transactional
	public List<TrafficLightDto> findAll(){
		List<TrafficLightEntity> list =  (List<TrafficLightEntity>) this.repository.findAll();
		return list.stream().map(TrafficLightEntity -> convertEntityToDto(TrafficLightEntity)).collect(Collectors.toList());
				
				
	}

	static TrafficLightDto convertEntityToDto(TrafficLightEntity entity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TrafficLightDto dto = modelMapper.map(entity, TrafficLightDto.class);
		return dto;
	}
	
	static TrafficLightEntity convertDtoToEntity(TrafficLightDto dto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TrafficLightEntity entity = modelMapper.map(dto, TrafficLightEntity.class);
		return entity;
	}
}
