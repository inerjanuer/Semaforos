package com.metodos.formales.system.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.sensor.model.SensorEntity;
import com.metodos.formales.system.dao.SystemDao;
import com.metodos.formales.system.dto.SystemDto;
import com.metodos.formales.system.model.SystemEntity;

@Service
public class SystemService {
	
	@Autowired
	private SystemDao repository;
	
	static ModelMapper modelMapper = new ModelMapper();

	public SystemService(SystemDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public SystemDto findById(long id) {
		return convertEntityToDto(this.repository.findById(id));
	}
	
	@Transactional
	public SystemDto findByName(String name) {
		return convertEntityToDto(this.repository.findByName(name));
	}
	
	@Transactional
	public List<SystemDto> findByType(String type) {
		List<SystemEntity> list = this.repository.findByType(type); 
		return list.stream().map(sensorEntity -> convertEntityToDto(sensorEntity)).collect(Collectors.toList());
	}
	
	static SystemDto convertEntityToDto(SystemEntity entity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SystemDto dto = modelMapper.map(entity, SystemDto.class);
		return dto;
	}
	
	static SystemEntity convertDtoToEntity(SystemDto dto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SystemEntity entity = modelMapper.map(dto, SystemEntity.class);
		return entity;
	}
	

}
