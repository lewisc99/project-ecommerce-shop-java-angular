package com.lewis.repositories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewis.entities.State;
import com.lewis.repositories.StateRepository;

@Service
public class StateService {

	
	
	@Autowired
	private StateRepository repository;
	
	
	public List<State> getStates()
	{
		
		return repository.findAll();
	}
}
