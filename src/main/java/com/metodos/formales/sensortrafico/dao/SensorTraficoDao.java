package com.metodos.formales.sensortrafico.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.sensortrafico.entity.SensorTraficoEntity;

@Repository
public interface SensorTraficoDao extends JpaRepository<SensorTraficoEntity , Long>{

	public SensorTraficoEntity findById(long id);
}
