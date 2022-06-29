package com.lewis.repositories.services;

import java.util.List;

import com.lewis.entities.Country;

public interface CountryService {

	
	public List<Country> getCountries();
	public Country getCountryById(int id);
}
