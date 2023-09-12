package com.instagoogle.findprofile.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagoogle.findprofile.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> listing() {
		
		Category cat1 = new Category(1, "Mães");
		
		List<Category> table = new ArrayList<>();
		table.add(cat1);
		
		return table;
	}

}

