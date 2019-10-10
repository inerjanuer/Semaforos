package com.metodos.formales.roles.dto;

import java.io.Serializable;

public class RolesDto implements Serializable {

	private static final long serialVersionUID = 8811633830777186990L;

	private long id;

	private String name;

	public RolesDto() {
	}

	public RolesDto(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
