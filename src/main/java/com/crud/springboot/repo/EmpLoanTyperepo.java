package com.crud.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.springboot.model.EmpLoanType;

public interface EmpLoanTyperepo extends JpaRepository<EmpLoanType,Integer> {

}
