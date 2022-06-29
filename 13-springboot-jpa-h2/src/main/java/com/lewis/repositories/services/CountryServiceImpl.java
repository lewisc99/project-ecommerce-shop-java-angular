package com.lewis.repositories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewis.entities.Country;
import com.lewis.repositories.CountryRepository;

@Service

public class CountryServiceImpl implements CountryService {

	
	@Autowired
	private CountryRepository repository;
	
	
	
	public List<Country> getCountries()
	{
		
		return repository.findAll();
	}



	@Override
	public Country getCountryById(int id) {
	
		
		
		return repository.getById(id);
	}
	
}
