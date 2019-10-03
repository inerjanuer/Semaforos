package com.metodos.formales.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.usuario.dao.UsuarioDao;
import com.metodos.formales.usuario.entity.UsuarioEntity;

@Service
@Transactional(readOnly = true)
public class UsuarioService {

	@Autowired
	private UsuarioDao repository;

	public UsuarioService(UsuarioDao repository) {
		this.repository = repository;
	}
	
	@Transactional
	public UsuarioEntity save(UsuarioEntity entity) {
		return this.repository.save(entity);
	}
	
	@Transactional
	public void delete(UsuarioEntity entity) {
		this.repository.delete(entity);
	}
	
	public List<UsuarioEntity> findAll(){
		return this.repository.findAll();
	}
	
	public UsuarioEntity findById(long id) {
		return this.repository.findById(id);
	}
}
