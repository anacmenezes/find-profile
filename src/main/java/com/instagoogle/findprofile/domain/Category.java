package com.instagoogle.findprofile.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	private List<Profile> profile = new ArrayList<>();
	private List<Tag> tag = new ArrayList<>();
	public Category(Integer id, String name, List<Profile> profile, List<Tag> tag) {
		super();
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.tag = tag;
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
	public List<Profile> getProfile() {
		return profile;
	}
	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, profile, tag);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(profile, other.profile) && Objects.equals(tag, other.tag);
	}
}
