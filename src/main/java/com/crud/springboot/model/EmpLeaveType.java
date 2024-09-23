package com.crud.springboot.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Leave_Type")
public class EmpLeaveType {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Leave_No")
	private Long leaveNo;

	@Column(name = "Leave_Type", unique=false)
	private String leaveType;

	@Column(name = "Leave_subtype")
	private String leaveSubtype;
	
	@Column(name = "Emp_No")
	private int empNo;
	
	 @NotNull
	@Column(name = "Numberofdays")
	private int numberofdays;
	
	@Column(name = "status")
	private String status;

	

	public int getNumberofdays() {
		return numberofdays;
	}

	public void setNumberofdays(int newBalance) {
		this.numberofdays = newBalance;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

	@ManyToOne
	@JoinColumn(name = "Emp_No", referencedColumnName = "Emp_No", insertable = false, updatable = false)
	private EmpDetails empDetails;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmpLeaveType() {
	}

	public EmpLeaveType(String string, String string2, String string3,int k) {

	}

	public EmpLeaveType(Long leaveNo, String leaveType, String leaveSubtype,int numberofdays, String status) {
		super();
		this.leaveNo = leaveNo;
		this.leaveType = leaveType;
		this.leaveSubtype = leaveSubtype;
		
		this.numberofdays=numberofdays;
		this.status = status;
	}

	public Long getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(Long leaveNo) {
		this.leaveNo = leaveNo;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveSubtype() {
		return leaveSubtype;
	}

	public void setLeaveSubtype(String leaveSubtype) {
		this.leaveSubtype = leaveSubtype;
	}

	@OneToMany(mappedBy = "leaveType", cascade = CascadeType.ALL)
	private List<InwardDetails> parent;

}