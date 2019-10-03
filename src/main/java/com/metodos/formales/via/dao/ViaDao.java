package com.metodos.formales.via.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.via.entity.ViaEntity;

@Repository
public interface ViaDao extends JpaRepository<ViaEntity, Long>{

	public ViaEntity findById(long id);
}
