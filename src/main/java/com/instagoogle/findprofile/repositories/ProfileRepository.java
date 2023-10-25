package com.instagoogle.findprofile.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagoogle.findprofile.domain.Category;
import com.instagoogle.findprofile.domain.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>	{
	
	@Transactional(readOnly=true)
    @Query 
    Optional<Profile> findByCategoriesIn(List<Category> categories);
}
