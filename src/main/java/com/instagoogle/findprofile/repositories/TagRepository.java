package com.instagoogle.findprofile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagoogle.findprofile.domain.Tags;

@Repository
public interface TagRepository	extends JpaRepository<Tags, Integer> {

}
