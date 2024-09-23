package com.crud.springboot.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.model.LeaveSanctioned;
import com.crud.springboot.model.LoanSansed;
import com.crud.springboot.repo.InwaedDetailsRepository;
import com.crud.springboot.repo.LeaveSanctionedRepository;
import com.crud.springboot.repo.Loansansrepo;

import jakarta.transaction.Transactional;
@Service
public class LoanService {
	@Autowired
	InwaedDetailsRepository inrepo;
	@Autowired
	Loansansrepo loanrepo;
	@Autowired
	LeaveSanctionedRepository leavesansrepo;
	
	
	

	public String sansnumber() {
        return String.format("%06d", new Random().nextInt(1000000));
    }
	


	@Transactional
	public void loanAction(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			System.out.println("leaveAction");
			if ("pending".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("waiting for assistant");
				inrepo.save(parentEntity);

			}
		}
	}
	@Transactional
	public void asstantAction(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			System.out.println("leaveAction");
			if ("waiting for assistant".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("waiting for assistant manager");
				inrepo.save(parentEntity);

			}
		}
	}

	@Transactional
	public void managerAction(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			System.out.println("leaveAction");
			if ("waiting for assistant manager".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("waiting for manager");
				inrepo.save(parentEntity);

			}
		}
	}
	@Transactional
	public void ManagerAction(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			if ("waiting for manager".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("manager also approved");
				inrepo.save(parentEntity);
				
				 if ("Loan".equals(parentEntity.getRequestType())) {
					LoanSansed loan=new  LoanSansed();
					
					loan.setEmpDetails(parentEntity.getEmpDetails());
					loan.setEmpNo(parentEntity.getEmpDetails().getEmpNo());
					loan.setDesignation(parentEntity.getEmpDetails().getDesignation());
			            loan.setEmpname(parentEntity.getEmpDetails().getEmpName());
			            loan.setJionDate(parentEntity.getEmpDetails().getJoinDate());
					           
			            loan.setReferenceNo(parentEntity.getReferenceNo());
			            loan.setSanctionedNo(sansnumber());

			            loan.setStatus("Approved");
			            loan.setInwardDetails(parentEntity);

			            loanrepo.save(loan);
	                          inrepo.save(parentEntity);
			
					
					}
}
		}
	}
	@Transactional
	public void Assistantreject(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			if ("waiting for assistant".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("rejected by assistant");
				inrepo.save(parentEntity);
		
	
			}
		}
	}
	public void Assistantmanagerreject(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			if ("waiting for assistant manager".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("rejected by assistantmanager");
				inrepo.save(parentEntity);
		
	
			}
		}
	}
	public void Managerreject(int parentId) {
		Optional<InwardDetails> parentOptional = inrepo.findById(parentId);
		if (parentOptional.isPresent()) {
			InwardDetails parentEntity = parentOptional.get();
			if ("waiting for manager".equals(parentEntity.getStatus())) {
				parentEntity.setStatus("rejected by manager");
				inrepo.save(parentEntity);
		
	
			}
		}
	}
}