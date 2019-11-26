package com.metodos.formales.usuario.service;

import com.metodos.formales.usuario.entity.UsuarioEntity;

public interface IUserService {

	public UsuarioEntity findByNombre(String username);
}
