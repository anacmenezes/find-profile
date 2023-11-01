package com.instagoogle.findprofile.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.dto.ProfileDTO;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles
class ProfileRepositoryTest {

	@Autowired
	ProfileRepository profileRepository;
	@Autowired
	EntityManager entityManager;

	@Test
	@DisplayName("Should get Profile successfully from DB")
	void findByCategoriesInCase1() {
		List<Category> categories = new ArrayList<>();
		ProfileDTO data = new ProfileDTO(null, "Test");
		this.createProfile(data);

		Optional<Profile> result = this.profileRepository.findByCategoriesIn(categories);

		assertThat(result.isPresent()).isTrue();
	}

	private Profile createProfile(ProfileDTO data) {
		Profile newProfile = new Profile(data);
		this.entityManager.persist(newProfile);
		return newProfile;
	}

	@Test
	@DisplayName("Should not get Profile from DB when user not exists")
	void findByCategoriesInCase2() {
		List<Category> categories = new ArrayList<>();
		
		Optional<Profile> result = this.profileRepository.findByCategoriesIn(categories);

		assertThat(result.isEmpty()).isTrue();
	}

}
