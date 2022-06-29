package com.lewis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lewis.entities.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
