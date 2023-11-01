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
    public void testFindProfileById() {
    	
        Profile profile = new Profile();
        profile.setId(1);
        profile.setName("Test profile");

        when(profileRepository.findById(1)).thenReturn(Optional.of(profile));

        Profile obj = profileService.find(1);

        assertEquals(profile, obj);
    }

    @Test
    public void testFindAllProfiles() {
    	
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(1, "Profile 1 test"));
        profiles.add(new Profile(2, "Profile 2 test"));

        when(profileRepository.findAll()).thenReturn(profiles);

        List<Profile> obj = profileService.findAll();

        assertEquals(profiles, obj);
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