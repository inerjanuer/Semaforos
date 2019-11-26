package com.metodos.formales.usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metodos.formales.usuario.dao.UsuarioDao;
import com.metodos.formales.usuario.entity.UsuarioEntity;

@Service
@Transactional(readOnly = true)
public class UsuarioService implements IUserService, UserDetailsService {

	@Autowired
	private UsuarioDao repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity user = repository.findByNombre(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getContrasena(),  true
				, true, true, true, authorities);
	}

	@Override
	public UsuarioEntity findByNombre(String username) {
		return this.repository.findByNombre(username);
	}

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
	
	@Transactional
	public List<UsuarioEntity> findAll(){
		return this.repository.findAll();
	}
	
	@Transactional
	public UsuarioEntity findById(long id) {
		return this.repository.findById(id);
	}
}
