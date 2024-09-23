package com.crud.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.LeaveSanctioned;
import com.crud.springboot.repo.LeaveSanctionedRepository;

@Service
public class LeaveSanctionedService {
	@Autowired
	LeaveSanctionedRepository leaveSanctionedRepository; 
	 public List<LeaveSanctioned> getAllLeaveSanctioned() {
	        return leaveSanctionedRepository.findAll();
	    }

}
