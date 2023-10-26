package com.instagoogle.findprofile.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.instagoogle.findprofile.dto.ProfileDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String name;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="PROFILE_CATEGORY", 
	joinColumns = @JoinColumn(name="profile_id"), 
	inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> categories = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="PROFILES_TAGS", 
		joinColumns = @JoinColumn(name="profiles_id"), 
		inverseJoinColumns = @JoinColumn(name="tags_id")
	)
	private List<Tag> tags = new ArrayList<>();
	
	public Profile() {
	}

	public Profile(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Profile(ProfileDTO data) {
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
