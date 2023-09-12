package com.instagoogle.findprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.instagoogle.findprofile.repositories.CategoryRepository;
import com.instagoogle.findprofile.repositories.ProfileRepository;
import com.instagoogle.findprofile.repositories.TagRepository;

@SpringBootApplication
public class FindprofileApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FindprofileApplication.class, args);
	}
	
	@Autowired
	private CategoryRepository catRepository;
	@Autowired
	private ProfileRepository ProRepository;
	@Autowired
	private TagRepository tagRepository;

	@Override
	public void run(String... enderecoeRepository) throws Exception {
		
		catRepository.deleteAll();
		ProRepository.deleteAll();
		tagRepository.deleteAll();
		
	}
}
