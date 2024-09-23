package com.crud.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.springboot.model.EmpDetails;
import com.crud.springboot.model.Managerlogins;

public interface Mangerlogi extends JpaRepository<Managerlogins,String> {
 
	Optional<Managerlogins> findByUsername(String username);
	
}
