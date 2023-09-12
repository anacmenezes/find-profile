package com.instagoogle.findprofile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.instagoogle.findprofile.domain.Tag;
import com.instagoogle.findprofile.dto.TagDTO;
import com.instagoogle.findprofile.repositories.TagRepository;

@Service
public class TagService {
	
	@Autowired
	private TagRepository repo;

	public Tag find(Integer id) {
		Optional<Tag> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Tag insert(Tag obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Tag update(Tag obj) {
		Tag newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw (null);
		}
	}
	
	public List<Tag> findAll() {
		return repo.findAll();
	}	
	
	public Tag fromDTO(TagDTO objDto) {
		return new Tag(objDto.getId(), objDto.getName());
	}

	private void updateData(Tag newObj, Tag obj) {
		newObj.setName(obj.getName());
	}
}
