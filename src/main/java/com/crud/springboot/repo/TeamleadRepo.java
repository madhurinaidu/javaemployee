package com.crud.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.springboot.model.TeamLead;
import com.crud.springboot.model.hrlogin;

public interface TeamleadRepo extends JpaRepository<TeamLead,String> {

	Optional<TeamLead> findByUsername(String username);
	

}
