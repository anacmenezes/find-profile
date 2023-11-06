package com.instagoogle.findprofile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.instagoogle.findprofile.domain.Tags;
import com.instagoogle.findprofile.dto.TagDTO;
import com.instagoogle.findprofile.repositories.TagRepository;

@Service
public class TagService {
	
	@Autowired
	private TagRepository repo;

	public Tags find(Integer id) {
		Optional<Tags> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Tags insert(Tags obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Tags update(Tags obj) {
		Tags newObj = find(obj.getId());
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
	
	public List<Tags> findAll() {
		return repo.findAll();
	}	
	
	public Tags fromDTO(TagDTO objDto) {
		return new Tags(objDto.getId(), objDto.getName());
	}

	private void updateData(Tags newObj, Tags obj) {
		newObj.setName(obj.getName());
	}
}
