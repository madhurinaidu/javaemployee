package com.crud.springboot.service;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.EmpLeaveType;
import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.repo.InwaedDetailsRepository;
import com.crud.springboot.repo.LeaveTypeRepositrory;

import jakarta.persistence.EntityNotFoundException;
@Service
public class InwardDetailService {
	
	@Autowired
	InwaedDetailsRepository inrepo;
	@Autowired
	LeaveTypeRepositrory leaveTypeRepository; 
	
	
	
	public String reference() {
        return String.format("%04d", new Random().nextInt(10000));
    }

	public String grievence() {
        return String.format("%08d", new Random().nextInt(100000000));
    }
	public InwardDetails Saveall(InwardDetails inward) {

        inward.setReferenceNo(reference());
        inward.setGrevianceNo(grievence());
		
			return inrepo.save(inward);
	}
	
	
	 public List<InwardDetails> getAllInward() {
	        return inrepo.findAll();
	    }
	  public List<InwardDetails> Manager() {
	        return inrepo.findBystatusAndRequestType("waiting for manager","leave");
	    }
	  public List<InwardDetails> hr() {
	        return inrepo.findBystatusAndRequestType("waiting for hr","Leave");
	    }
	 
	  public List<InwardDetails> teamlead() {
	        return inrepo.findBystatusAndRequestType("pending","Leave");
	    }
	public InwardDetails getdetailsbyEmpNo(int InId) {
		return inrepo.findById(InId).orElse(null);
	}
	 
	
	 public List<InwardDetails> findLeaveRequests() {
	        return inrepo.findByRequestType("leave");
	    }
	 public List<InwardDetails> findLoanRequests() {
	        return inrepo.findByRequestType("loan");
	    }
	

	
	
	
	
}
