package com.metodos.formales.roles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.roles.entity.RolesEntity;

@Repository
public interface RolesDao extends JpaRepository<RolesEntity, Long> {

	public RolesEntity findById(long id);
}
