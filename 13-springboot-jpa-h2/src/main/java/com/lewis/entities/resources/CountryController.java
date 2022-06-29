package com.lewis.entities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.entities.Country;
import com.lewis.repositories.services.CountryService;

@RestController
@RequestMapping("api/countries")
@CrossOrigin("http://localhost:4200/")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	
	
	
	@GetMapping()
	public ResponseEntity<List<Country>> getCountries()
	{
		List<Country> countries = countryService.getCountries();
		
		
		return ResponseEntity.ok().body(countries);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Country> getCountry(@PathVariable int id)
	{
		
		Country countryById = countryService.getCountryById(id);
		
		return ResponseEntity.ok().body(countryById);
		
	}
	
}
