package com.metodos.formales.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.formales.usuario.entity.UsuarioEntity;

@Repository
public interface UsuarioDao extends JpaRepository<UsuarioEntity, Long>{

	public UsuarioEntity findById(long id);
	
	public UsuarioEntity findByNombre(String nombre);
}
