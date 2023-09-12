package com.instagoogle.findprofile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.dto.ProfileDTO;
import com.instagoogle.findprofile.repositories.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository repo;

	public Profile find(Integer id) {
		Optional<Profile> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Profile insert(Profile obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Profile update(Profile obj) {
		Profile newObj = find(obj.getId());
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
	
	public List<Profile> findAll() {
		return repo.findAll();
	}	
	
	public Profile fromDTO(ProfileDTO objDto) {
		return new Profile(objDto.getId(), objDto.getName());
	}

	private void updateData(Profile newObj, Profile obj) {
		newObj.setName(obj.getName());
	}
}
