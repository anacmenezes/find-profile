package com.instagoogle.findprofile.dto;

import java.io.Serializable;

import com.instagoogle.findprofile.domain.Profile;

public class ProfileDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	public ProfileDTO() {
	}

	public ProfileDTO(Profile obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}