package com.crud.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.springboot.model.hrlogin;

public interface Hrrepo extends JpaRepository<hrlogin,String> {
	 
		Optional<hrlogin> findByUsername(String username);
		
	

}
