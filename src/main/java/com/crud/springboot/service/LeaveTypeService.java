package com.crud.springboot.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.EmpDetails;
import com.crud.springboot.model.EmpLeaveType;
import com.crud.springboot.model.EmpLoanType;
import com.crud.springboot.model.Grivienceentity;
import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.repo.EmpDetailsRepository;
import com.crud.springboot.repo.EmpLoanTyperepo;
import com.crud.springboot.repo.Griviencerepo;
import com.crud.springboot.repo.InwaedDetailsRepository;
import com.crud.springboot.repo.LeaveTypeRepositrory;

import jakarta.servlet.http.HttpSession;

@Service
public class LeaveTypeService {
	@Autowired
	LeaveTypeRepositrory leaveTypeRepository;
	@Autowired
	private EmpDetailsRepository empDetailsRepository;
	@Autowired
	Griviencerepo griviencerepo;
	@Autowired
	InwaedDetailsRepository inwaedDetailsRepository;
	@Autowired
	EmpLoanTyperepo empLoanTyperepo;

	public EmpLeaveType Saveall(EmpLeaveType empLeaveType) {

		return leaveTypeRepository.save(empLeaveType);
	}

	public List<EmpLeaveType> getAllLeavetype() {
		return leaveTypeRepository.findAll();
	}

	public String generated() {
		return String.format("%06d", new Random().nextInt(1000000));
	}
	public String reference() {
		return String.format("%04d", new Random().nextInt(10000));
	}
	
	 public int generateRandomNumber() {
	        int min = 10000000; // Smallest 8-digit number
	        int max = 99999999; // Largest 8-digit number
	        return ThreadLocalRandom.current().nextInt(min, max + 1);
	    }

	public void date() {
		// Create a new LocalDateTime object with the current date and time
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime); // This will print the current date and time
	}
	

	public String applyLeave(int empId, String leaveSubtype, String leaveType, int numberofdays, Date fromdate,
			Date todate, HttpSession session) {
		int authenticatedEmpno = (int) session.getAttribute("authenticatedEmpno");
	      
		EmpDetails employee = empDetailsRepository.findByempNo(empId);
		 if (empId == authenticatedEmpno) {
		      
		if (employee != null) {
			System.out.println("condition aval");

			int availableLeaveBalance = 0;
			if ("Sick Leave".equals( leaveSubtype)) {
				System.out.println("sickleave");
				availableLeaveBalance = employee.getSickleave();

			} else if ("Personal Leave".equals( leaveSubtype))
				availableLeaveBalance = employee.getPersnalleave();
			System.out.println("gvghghvghvaction " + availableLeaveBalance);
			System.out.println(numberofdays);
			if (availableLeaveBalance >= numberofdays) {
				// Deduct leave balance
				System.out.println("condition");
				System.out.println(leaveSubtype);
				if (leaveSubtype.equals("Sick Leave")) {
					System.out.println("sickleave");
					employee.setSickleave(employee.getSickleave() - numberofdays);
					System.out.println("gvghghvghvaction  " + availableLeaveBalance);

				} else if (leaveSubtype.equals("Personal Leave")) {
					System.out.println("nnggbgjbbalance");
					employee.setPersnalleave(employee.getPersnalleave() - numberofdays);
				}

				// Save leave request
				EmpLeaveType leaveRequest = new EmpLeaveType();
				leaveRequest.setEmpNo(empId);
				leaveRequest.setLeaveType(leaveType);
				leaveRequest.setLeaveSubtype(leaveSubtype);
				leaveRequest.setStatus("pending");
				leaveRequest.setNumberofdays(numberofdays);
				leaveTypeRepository.save(leaveRequest);
				Grivienceentity entity = new Grivienceentity();
				entity.setEmpNo(empId);
				entity.setFromdate(fromdate);
				entity.setTodate(todate);
				entity.setGrivienceNo(generated());
				entity.setInwarddate(LocalDate.now());
				entity.setInwardNo(generateRandomNumber());
				griviencerepo.save(entity);
				InwardDetails inward = new InwardDetails();
				inward.setEmpNo(empId);
				inward.setGrevianceNo(entity.getGrivienceNo());
				inward.setInwardNo(entity.getInwardNo());
				inward.setInwardDate(entity.getInwarddate());
				inward.setStatus("pending");
				inward.setRemarks("remarks");
				inward.setEmpDesig(employee.getDesignation());
				inward.setGrevianceDate(LocalDate.now());
				inward.setRequestSubtype(leaveRequest.getLeaveSubtype());
				inward.setRequestType(leaveRequest.getLeaveType());
				inward.setReferenceNo(reference());
				inwaedDetailsRepository.save(inward);
				return "Leave request submitted successfully"; // Leave applied successfully
			} else {
				return "Insufficient leave balance"; // Insufficient leave balance
			}
		} else {
			return "Invalid empid"; // Employee not found
		}
		 }
		return "Invalid empid";
	}
	public String applyLoan(int empId, String loanSubtype, String loanType, int loanamount,HttpSession session)
			 {
		EmpDetails employee = empDetailsRepository.findByempNo(empId);
		int authenticatedEmpno = (int) session.getAttribute("authenticatedEmpno");
		if (empId == authenticatedEmpno) {
			
		if (employee != null) {
			System.out.println("employee available");

			int availableamount = 0;
			if ("Home Loan".equals( loanSubtype)) {
				System.out.println(loanSubtype);
				availableamount = employee.getHomeloan();

			} else if ("Personal Loan".equals( loanSubtype))
				availableamount = employee.getPersnalloan();
			System.out.println("gvghghvghvaction " + availableamount);
			System.out.println(availableamount);
			System.out.println(loanamount);

			if (availableamount >= loanamount) {
				// Deduct leave balance
				System.out.println(loanamount);
				System.out.println("condition");
				System.out.println(loanSubtype);
				if (loanSubtype.equals("Home Loan")) {
					System.out.println(loanSubtype);
					System.out.println("Home Loan");
					employee.setHomeloan(employee.getHomeloan()-loanamount);
                     System.out.println(employee.getHomeloan());
				} else if (loanSubtype.equals("Personal Loan")) {
					System.out.println("nnggbgjbbalance");
					employee.setPersnalloan(employee.getPersnalloan()-loanamount);
				}

				// Save leave request
				EmpLoanType empLoanType = new EmpLoanType();
				empLoanType.setEmpNo(empId);
				empLoanType.setLloanType(loanType);
				empLoanType.setLoanSubtype(loanSubtype);
				empLoanType.setStatus("pending");
				empLoanType.setLoanamount(loanamount);
				empLoanTyperepo.save(empLoanType);
				Grivienceentity entity = new Grivienceentity();
				entity.setEmpNo(empId);
				entity.setGrivienceNo(generated());
				entity.setInwarddate(LocalDate.now());
				entity.setInwardNo(generateRandomNumber());
				griviencerepo.save(entity);
				InwardDetails inward = new InwardDetails();
				inward.setEmpNo(empId);
				inward.setGrevianceNo(entity.getGrivienceNo());
				inward.setInwardNo(entity.getInwardNo());
				inward.setInwardDate(entity.getInwarddate());
				inward.setStatus("pending");
				inward.setRemarks("remarks");
				inward.setEmpDesig(employee.getDesignation());
				inward.setGrevianceDate(LocalDate.now());
				inward.setRequestSubtype(empLoanType.getLoanSubtype());
				inward.setRequestType(empLoanType.getLloanType());
				System.out.println(inward.getRequestType());
				inward.setReferenceNo(reference());
				inwaedDetailsRepository.save(inward);
				return "Loan request submitted successfully"; // Leave applied successfully
			} else {
				return "Insufficient  balance"; // Insufficient leave balance
			}
		} else {
			return "Invalid empid"; // Employee not found
		}
		}
		return "Invalid empid";
	}

}