package com.instagoogle.findprofile.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.dto.ProfileDTO;
import com.instagoogle.findprofile.services.ProfileService;

@RestController
@RequestMapping(value ="/profiles")
public class ProfileResource {
	@Autowired
	private ProfileService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Profile> find(@PathVariable Integer id) {
		Profile obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProfileDTO>> findAll() {
		List<Profile> list = service.findAll();
		List<ProfileDTO> listDto = list.stream().map(obj -> new ProfileDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{categories}", method=RequestMethod.GET)
	public ResponseEntity<Profile> find(@PathVariable List<Category> categories) {
		Profile obj = service.findCategories(categories);
	    return ResponseEntity.ok().body(obj);
	}
}
