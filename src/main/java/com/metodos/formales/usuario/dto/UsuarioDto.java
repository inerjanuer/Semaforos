package com.metodos.formales.usuario.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = -3484741837469545380L;

	private Long id;

	private String nombre;

	private String email;

	private String contrasena;

	public UsuarioDto() {
	}

	public UsuarioDto(Long id, String nombre, String email, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
