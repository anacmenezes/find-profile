package com.instagoogle.findprofile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.repositories.ProfileRepository;
import com.instagoogle.findprofile.services.exception.ObjectNotFoundException;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository repo;
	
	public Profile findCategories(List<Category> categories) {
	    Optional<Profile> obj = repo.findByCategoriesIn(categories); 
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found!"));
	}
	
	public void findByCategoriesIn(List<Category> categories) {	
	}
}
