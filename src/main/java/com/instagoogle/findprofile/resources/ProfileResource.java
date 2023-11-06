package com.instagoogle.findprofile.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.services.ProfileService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/profiles", produces = {"application/json"})
@Tag(name = "profiles")
public class ProfileResource {
	@Autowired
	private ProfileService service;
	
	@RequestMapping(value = "/{categories}", method=RequestMethod.GET)
	public ResponseEntity<Profile> find(@PathVariable List<Category> categories) {
		Profile obj = service.findCategories(categories);
	    return ResponseEntity.ok().body(obj);
	}
}
