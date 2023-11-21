package com.instagoogle.findprofile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;
import com.instagoogle.findprofile.repositories.ProfileRepository;

public class ProfileServiceTest {

    @InjectMocks
    private ProfileService profileService;

    @Mock
    private ProfileRepository profileRepository;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindProfileByCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Category 1"));
        categories.add(new Category(2, "Category 2"));

        Profile profile = new Profile();
        profile.setId(1);
        profile.setName("Profile with categories test");

        when(profileRepository.findByCategoriesIn(categories)).thenReturn(Optional.of(profile));

        Profile obj = profileService.findCategories(categories);

        assertEquals(profile, obj);
    }
}