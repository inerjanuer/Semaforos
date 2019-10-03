package com.metodos.formales.sensorvelocidad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.sensorvelocidad.entity.SensorVelocidadEntity;

@Repository
public interface SensorVelocidadDao extends JpaRepository<SensorVelocidadEntity, Long>{

	public SensorVelocidadEntity findById(long id);
}
