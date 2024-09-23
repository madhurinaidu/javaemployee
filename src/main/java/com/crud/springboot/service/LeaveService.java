package com.crud.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.EmpDetails;
import com.crud.springboot.model.EmpLeaveType;
import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.model.LeaveSanctioned;
import com.crud.springboot.repo.EmpDetailsRepository;
import com.crud.springboot.repo.InwaedDetailsRepository;
import com.crud.springboot.repo.LeaveSanctionedRepository;
import com.crud.springboot.repo.LeaveTypeRepositrory;
import com.crud.springboot.repo.Loansansrepo;

import jakarta.transaction.Transactional;

@Service
public class LeaveService {
	@Autowired
	LeaveTypeRepositrory leaverepo;
	@Autowired
	LeaveTypeRepositrory leaveTypeRepository;
	@Autowired
	InwardDetailService inwardservice;

	@Autowired
	private EmpDetailsRepository empDetailsRepository;

	@Autowired
	InwaedDetailsRepository inrepo;
	@Autowired
	LeaveSanctionedRepository leavesansrepo;
	@Autowired
	Loansansrepo loanrepo;
	@Autowired
	private JavaMailSender javaMailSender;

	public String sansnumber() {
		return String.format("%06d", new Random().nextInt(1000000));
	}

	@Transactional
	public void leaveAction(int empNo) {
		System.out.println("leave action remove");
		// Optional<InwardDetails> parentOptional = inrepo.findById( empNo);
		List<InwardDetails> inwardList = inwardservice.getAllInward();

		for (InwardDetails inward : inwardList) {
			String requestType = inward.getStatus();
			System.out.println("status is+" + inward.getStatus());
			if ("pending".equals(requestType)) {
				inward.setStatus("waiting for hr");
				inrepo.save(inward);
				break;
			}
		}
	}

	@Transactional
	public void leaverejectAction(int parentId) {
		
		List<InwardDetails> inwardList = inwardservice.getAllInward();

		for (InwardDetails inward : inwardList) {
			String requestType = inward.getStatus();
			System.out.println("status is+" + inward.getStatus());
			if ("pending".equals(requestType)) {
				inward.setStatus("rejected by teamlead");
				inrepo.save(inward);
				break;
			}
		}
		
	}

	public void reject(int empNo) {
		Optional<InwardDetails> inwardOptional = inrepo.findById(empNo);
		if (inwardOptional.isPresent()) {
			InwardDetails inward = inwardOptional.get();
			if ("waitng for hr".equals(inward.getStatus()))
				;
			inward.setStatus("pending");
			inrepo.save(inward);
		}
	}

	@Transactional
	public void HrAcction(int parentId) {
		List<InwardDetails> inwardList = inwardservice.getAllInward();

		for (InwardDetails inward : inwardList) {
			String requestType = inward.getStatus();
			System.out.println("status is+" + inward.getStatus());
			if ("waiting for hr".equals(requestType)) {
				inward.setStatus("waiting for manager");
				inrepo.save(inward);
				break;
			}
		}

	}

	@Transactional
	public void Hrreject(int parentId) {
		List<InwardDetails> inwardList = inwardservice.getAllInward();

		for (InwardDetails inward : inwardList) {
			String requestType = inward.getStatus();
			System.out.println("status is+" + inward.getStatus());
			if ("waiting for hr".equals(requestType)) {
				inward.setStatus("rejected by hr");
				inrepo.save(inward);
				break;
			}
		}
		
		
	}

	@Transactional
	public void ManagerAction(int parentId, String to, String subject, String text) {
		List<InwardDetails> inwardList = inwardservice.getAllInward();
         System.out.println("manager approved");
		for (InwardDetails inward : inwardList) {
			String requestType = inward.getStatus();
			System.out.println("h"+requestType);
			if ("waiting for manager".equals(requestType)) {
				inward.setStatus("manager also approved");
				  SimpleMailMessage message = new SimpleMailMessage();
				  EmpDetails employee = inward.getEmpDetails ();
                   String name=employee.getEmpName();
				message.setTo(employee.getUsername());
		        message.setSubject("leave status");
		        message.setText("Hi "+name+"\n"+" your leave approved");
		        javaMailSender.send(message);
				inrepo.save(inward);
				System.out.println(inward.getInid());
				int empno = inward.getEmpNo();
				List<EmpLeaveType> children = leaverepo.findByempNo(empno);
				System.out.println("size is" + children.size());
				for (EmpLeaveType child : children) {
					if (child.getLeaveNo() == inward.getInid()) {
						if ("pending".equals(child.getStatus())) {
							System.out.println("accepted");
							System.out.println(child.getLeaveNo());

							child.setStatus("finally leaveapproved");
							leaverepo.save(child);

						}
					}
				}
				if ("Leave".equals(inward.getRequestType())) {

					LeaveSanctioned leavesAns = new LeaveSanctioned();
					leavesAns.setEmpDetails(inward.getEmpDetails());
					leavesAns.setEmpNo(inward.getEmpDetails().getEmpNo());
					leavesAns.setDesignation(inward.getEmpDetails().getDesignation());
					leavesAns.setEmpname(inward.getEmpDetails().getEmpName());
					leavesAns.setJionDate(inward.getEmpDetails().getJoinDate());

					leavesAns.setReferenceNo(inward.getReferenceNo());
					leavesAns.setSanctionedNo(sansnumber());

					leavesAns.setStatus("Approved");
					leavesAns.setInwardDetails(inward);
					System.out.println("leavesanstype12343354667");

					leavesansrepo.save(leavesAns);
					inrepo.save(inward);
					

				}
				System.out.println("leavetype12343354667");

				break;
			}
		}
	}

	@Transactional
	public void ManagerrjectAction(int parentId) {
		List<InwardDetails> inwardList = inwardservice.getAllInward();

		for (InwardDetails inward : inwardList) {
			String requestType = inward.getStatus();
			System.out.println("status is+" + inward.getStatus());
			if ("waiting for manager".equals(requestType)) {
				inward.setStatus("rejected by manager");
				inrepo.save(inward);
				
				int empno = inward.getEmpNo();
				System.out.println(empno);
				List<EmpLeaveType> children = leaverepo.findByempNo(empno);
				
				System.out.println("size is" + children.size());

				System.out.println("rejected by manager1");
				System.out.println("Number of Leave Requests: " + children.size());
				for (EmpLeaveType leaveRequest : children) {
					if (leaveRequest.getLeaveNo() == inward.getInid()) {
						if ("pending".equals(leaveRequest.getStatus())) {
							System.out.println("accepted");
							System.out.println(leaveRequest.getLeaveNo());

							leaveRequest.setStatus("leave rejected");
							leaverepo.save(leaveRequest);
                            System.out.println("days are"+leaveRequest.getNumberofdays());
                            EmpDetails employee = empDetailsRepository.findByempNo(leaveRequest.getEmpNo());
        					System.out.println("empnumber is"+leaveRequest.getEmpNo());
        					String leaveSubtype = leaveRequest.getLeaveSubtype();
        					System.out.println("leavetype is :"+leaveSubtype);
        					int numberofdays = leaveRequest.getNumberofdays();
        					
        					if ("Sick Leave".equals(leaveSubtype)) {
        						System.out.println("rejected by manager bloc condition");
        						employee.setSickleave(employee.getSickleave() + numberofdays);
        					} else if ("Personal Leave".equals(leaveSubtype)) {
        						employee.setPersnalleave(employee.getPersnalleave() + numberofdays);
        					}
						}
					}
					
				inrepo.save(inward);
				
				
			}
				break;
		}

	}}}
