package com.metodos.formales.system.dto;

import java.io.Serializable;

public class SystemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String type;

	public SystemDto() {
	}

	public SystemDto(long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
