package com.instagoogle.findprofile;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.repositories.CategoryRepository;
import com.instagoogle.findprofile.repositories.ProfileRepository;

@SpringBootApplication
public class FindprofileApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FindprofileApplication.class, args);
	}
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProfileRepository profileRepository;
//	@Autowired
//	private TagRepository tagRepository;

	@Override
	public void run(String... enderecoeRepository) throws Exception {
		
		Category cat1 = new Category(null, "Dupla maternidade");
		Category cat2 = new Category(null, "Culinária");
		Category cat3 = new Category(null, "Viajens");
		Category cat4 = new Category(null, "Artesanato");
		Category cat5 = new Category(null, "Arquitetura");
		
		Profile p1 = new Profile(null, "@duasmaeseummundo");
		Profile p2 = new Profile(null, "@duasmaesdopedro");
		Profile p3 = new Profile(null, "@igorochaoficia");
		Profile p4 = new Profile(null, "@comerrezarviajar");
		Profile p5 = new Profile(null, "@jambocria");
		Profile p6 = new Profile(null, "@cajuearq");
		
		cat1.getProfiles().addAll(Arrays.asList(p1, p2));
		cat2.getProfiles().addAll(Arrays.asList(p3));
		cat3.getProfiles().addAll(Arrays.asList(p2, p4));
		cat4.getProfiles().addAll(Arrays.asList(p5));
		cat5.getProfiles().addAll(Arrays.asList(p6));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().addAll(Arrays.asList(cat2));
		p4.getCategories().addAll(Arrays.asList(cat3));
		p5.getCategories().addAll(Arrays.asList(cat4));
		p6.getCategories().addAll(Arrays.asList(cat5));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		profileRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
