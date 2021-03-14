package com.reswebservice.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reswebservice.application.model.Userdetails;

public interface Userdetailsrepo extends JpaRepository<Userdetails, String> {

	Userdetails findByFirstname(String firstname);

	
}
