package com.metodos.formales.semaforo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.semaforo.entity.SemaforoEntity;

@Repository
public interface SemaforoDao extends JpaRepository<SemaforoEntity, Long>{

	public SemaforoEntity findById(long id);
}
