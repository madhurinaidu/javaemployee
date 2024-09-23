package com.crud.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "Loan_Type")

public class EmpLoanType {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Loan_No")
	private int loanNo;

	@Column(name = "Loan_Type", unique=false)
	private String lloanType;

	@Column(name = "Loan_subtype")
	private String loanSubtype;
	
	@Column(name = "Emp_No")
	private int empNo;
	
	 @NotNull
	@Column(name = "loanamount")
	private int loanamount;
	
	@Column(name = "status")
	private String status;

	

	public EmpLoanType(int loanNo, String lloanType, String loanSubtype, int empNo, @NotNull int loanamount,
			String status, EmpDetails empDetails) {
		super();
		this.loanNo = loanNo;
		this.lloanType = lloanType;
		this.loanSubtype = loanSubtype;
		this.empNo = empNo;
		this.loanamount = loanamount;
		this.status = status;
		this.empDetails = empDetails;
	}



	public int getLoanNo() {
		return loanNo;
	}



	public void setLoanNo(int loanNo) {
		this.loanNo = loanNo;
	}



	public String getLloanType() {
		return lloanType;
	}



	public void setLloanType(String lloanType) {
		this.lloanType = lloanType;
	}



	public String getLoanSubtype() {
		return loanSubtype;
	}



	public void setLoanSubtype(String loanSubtype) {
		this.loanSubtype = loanSubtype;
	}



	public int getEmpNo() {
		return empNo;
	}



	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}



	public int getLoanamount() {
		return loanamount;
	}



	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public EmpDetails getEmpDetails() {
		return empDetails;
	}



	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}



	public EmpLoanType() {
		super();
		// TODO Auto-generated constructor stub
	}



	@ManyToOne
	@JoinColumn(name = "Emp_No", referencedColumnName = "Emp_No", insertable = false, updatable = false)
	private EmpDetails empDetails;
	}
