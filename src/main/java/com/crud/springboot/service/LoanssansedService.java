package com.crud.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.LoanSansed;
import com.crud.springboot.repo.Loansansrepo;

@Service
public class LoanssansedService {
	
	@Autowired
	Loansansrepo loanSanctionedRepository; 
	


	public List<LoanSansed> getAllLoanSanctioned() {
		 return loanSanctionedRepository.findAll();
		 
	}

	
}
