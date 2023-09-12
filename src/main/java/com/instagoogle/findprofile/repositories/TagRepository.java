package com.instagoogle.findprofile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagoogle.findprofile.domain.Tag;

@Repository
public interface TagRepository	extends JpaRepository<Tag, Integer> {

}
