package com.metodos.formales.sensor.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.sensor.dao.SensorDao;
import com.metodos.formales.sensor.dto.SensorDto;
import com.metodos.formales.sensor.model.SensorEntity;

@Service
public class SensorService {
	
	@Autowired
	private SensorDao repository;
	
	static ModelMapper modelMapper = new ModelMapper();

	public SensorService(SensorDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public SensorDto findById(long id) {
		return convertEntityToDto(this.repository.findById(id));
	}
	
	public SensorDto save(SensorDto dto) {
		SensorEntity entity = convertDtoToEntity(dto);
		return convertEntityToDto(this.repository.save(entity));
	}
	
	
	static SensorDto convertEntityToDto(SensorEntity entity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SensorDto dto = modelMapper.map(entity, SensorDto.class);
		return dto;
	}
	
	static SensorEntity convertDtoToEntity(SensorDto dto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SensorEntity entity = modelMapper.map(dto, SensorEntity.class);
		return entity;
	}
	

}
