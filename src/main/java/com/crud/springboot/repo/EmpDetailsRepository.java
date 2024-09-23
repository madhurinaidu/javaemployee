package com.crud.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springboot.model.EmpDetails;
@Repository
public interface EmpDetailsRepository extends JpaRepository<EmpDetails, Long> {
	EmpDetails findByempNo(int empNo);
	EmpDetails findByUsername(String username);
	EmpDetails findByempNoAndUsername(int empid, String username);

	//Optional<EmpDetails> findByUsername(String username);
	
	
}
