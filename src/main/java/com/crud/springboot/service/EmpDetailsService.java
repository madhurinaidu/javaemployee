package com.crud.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.EmpDetails;
import com.crud.springboot.model.EmpLeaveType;
import com.crud.springboot.model.Managerlogins;
import com.crud.springboot.model.TeamLead;
import com.crud.springboot.model.hrlogin;
import com.crud.springboot.repo.EmpDetailsRepository;
import com.crud.springboot.repo.Hrrepo;
import com.crud.springboot.repo.LeaveTypeRepositrory;
import com.crud.springboot.repo.Mangerlogi;
import com.crud.springboot.repo.TeamleadRepo;
@Service
public class EmpDetailsService {
	 @Autowired
	 private EmpDetailsRepository empDetailsRepository;
	 @Autowired
	 LeaveTypeRepositrory leaveTypeRepositrory;
	 @Autowired
	 Mangerlogi mangerlogirepo;
	 @Autowired
	 TeamleadRepo tmrepo;
	 @Autowired
	 Hrrepo hrrepo;
	   
	    
	    public List<EmpDetails> getAllEmpDetails() {
	        return empDetailsRepository.findAll();
	    }
	    public boolean employeeExists(int empNo,String leaveType,String leaveSubtype,int numberofdays,String status) {
	        EmpDetails empDetails = empDetailsRepository.findByempNo(empNo);
                 EmpLeaveType emp=new EmpLeaveType();
                 emp.setEmpNo(empNo);
                 emp.setLeaveType(leaveType);
                 emp.setLeaveSubtype(leaveSubtype);
                 emp.setNumberofdays(numberofdays);
                 emp.setStatus(status);
                         leaveTypeRepositrory.save(emp);
	        return true;
	    }
	    public EmpDetails findByUsername(String username) {
	    	EmpDetails empDetails=empDetailsRepository.findByUsername(username);
			return empDetails;
	    
	    }

	    public Managerlogins findByManagerUsername(String username) {
	    	Managerlogins managerDetails=mangerlogirepo.findByUsername(username).orElse(null);
			return  managerDetails;
	    
	    }
	
	    public hrlogin findByhrUsername(String username) {
	    	hrlogin hr=hrrepo.findByUsername(username).orElse(null);
			return hr;
	    
	    }
	    public TeamLead findBytemaleadUsername(String username) {
	    	TeamLead teamlead=tmrepo.findByUsername(username).orElse(null);
			return teamlead;
	    
	    }
		 public boolean validateEmpid(int empId, String username) {
        EmpDetails empDetails = empDetailsRepository.findByempNoAndUsername(empId, username);
        return empDetails != null;
    }
}
