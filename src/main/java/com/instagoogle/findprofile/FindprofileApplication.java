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
		Category cat2 = new Category(null, "Maternidade");
		Category cat3 = new Category(null, "Infantil");
		Category cat4 = new Category(null, "Viagens");
		Category cat5 = new Category(null, "Programação");
		Category cat6 = new Category(null, "Arquitetura");
		Category cat7 = new Category(null, "Entretenimento");
		Category cat8 = new Category(null, "Artesanato");
		Category cat9 = new Category(null, "Culinária");
		
		Profile p1 = new Profile(null, "@duasmaeseummundo");
		Profile p2 = new Profile(null, "@duasmaesdopedro");
		Profile p3 = new Profile(null, "@duasmaesdobenjamin");
		Profile p4 = new Profile(null, "@majoeasmamaes");
		
		Profile p5 = new Profile(null, "@thaynacalil_jolstead");
		Profile p6 = new Profile(null, "@_minhacasinha");
		
		Profile p7 = new Profile(null, "@isaacdovine");
		Profile p8 = new Profile(null, "@mariaclara_e_jp");
		
		Profile p9 = new Profile(null, "@amantesdeestrada");
		Profile p10 = new Profile(null, "@duasmalaseumdestino");
		Profile p11 = new Profile(null, "@viajabrito");
		
		Profile p12 = new Profile(null, "@minasprogramam");
		Profile p13 = new Profile(null, "@meninasdigitais");
		Profile p14 = new Profile(null, "@programaria");
		Profile p15 = new Profile(null, "@loiane");		

		Profile p16 = new Profile(null, "@cajuearq");
		Profile p17 = new Profile(null, "@alluzearquitetura");
		Profile p18 = new Profile(null, "@estudioj.ribeiro");
		Profile p19 = new Profile(null, "@littleone.arquitetura");
		
		Profile p20 = new Profile(null, "@meltedvideos");
		Profile p21 = new Profile(null, "@nazareamarga");
		Profile p22 = new Profile(null, "@soueunavida");
		Profile p23 = new Profile(null, "@itsmateuscosta");
		
		Profile p24 = new Profile(null, "@jambocria");
		Profile p25 = new Profile(null, "@simple.feitoamao");
		
		Profile p26 = new Profile(null, "@ismaelcocinillas");
		Profile p27 = new Profile(null, "@gzfoodqood");
		Profile p28 = new Profile(null, "@gui.tank");
		Profile p29 = new Profile(null, "@igorochaoficial");
		Profile p30 = new Profile(null, "@thallitaxavier");
		
		cat1.getProfiles().addAll(Arrays.asList(p1, p2, p3,p4));
		cat2.getProfiles().addAll(Arrays.asList(p1, p2, p3,p4, p5, p6));
		cat3.getProfiles().addAll(Arrays.asList(p7, p8));
		cat4.getProfiles().addAll(Arrays.asList(p1, p9, p10, p11));
		cat5.getProfiles().addAll(Arrays.asList(p12, p13, p14, p15));
		cat6.getProfiles().addAll(Arrays.asList(p16, p17, p18, p19));
		cat7.getProfiles().addAll(Arrays.asList(p7, p8, p20, p21, p22, p23));
		cat8.getProfiles().addAll(Arrays.asList(p24, p25));
		cat9.getProfiles().addAll(Arrays.asList(p6, p26, p27, p28, p29, p30));
				
		p1.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1, cat2));
		p4.getCategories().addAll(Arrays.asList(cat1, cat2));
		
		p5.getCategories().addAll(Arrays.asList(cat2));
		p6.getCategories().addAll(Arrays.asList(cat2, cat9));
		
		p7.getCategories().addAll(Arrays.asList(cat3, cat7));
		p8.getCategories().addAll(Arrays.asList(cat3, cat7));
		
		p9.getCategories().addAll(Arrays.asList(cat4));
		p10.getCategories().addAll(Arrays.asList(cat4));
		p11.getCategories().addAll(Arrays.asList(cat4));
		
		p12.getCategories().addAll(Arrays.asList(cat5));
		p13.getCategories().addAll(Arrays.asList(cat5));
		p14.getCategories().addAll(Arrays.asList(cat5));
		p15.getCategories().addAll(Arrays.asList(cat5));
		
		p16.getCategories().addAll(Arrays.asList(cat6));
		p17.getCategories().addAll(Arrays.asList(cat6));
		p18.getCategories().addAll(Arrays.asList(cat6));
		p19.getCategories().addAll(Arrays.asList(cat6));
		
		p20.getCategories().addAll(Arrays.asList(cat7));
		p21.getCategories().addAll(Arrays.asList(cat7));
		p22.getCategories().addAll(Arrays.asList(cat7));
		p23.getCategories().addAll(Arrays.asList(cat7));
		
		p24.getCategories().addAll(Arrays.asList(cat8));
		p25.getCategories().addAll(Arrays.asList(cat8));
		
		p26.getCategories().addAll(Arrays.asList(cat9));
		p27.getCategories().addAll(Arrays.asList(cat9));
		p28.getCategories().addAll(Arrays.asList(cat9));
		p29.getCategories().addAll(Arrays.asList(cat9));
		p30.getCategories().addAll(Arrays.asList(cat9));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		profileRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30 ));
	}
}
