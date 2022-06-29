package com.lewis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lewis.entities.Country;


@CrossOrigin("http://localhost:4200/")

public interface CountryRepository  extends JpaRepository<Country,Integer>{
	
}
