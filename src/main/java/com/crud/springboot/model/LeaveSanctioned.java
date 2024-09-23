package com.crud.springboot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leave_Sanctioned")
public class LeaveSanctioned {
	@Id
	@Column(name = "Leave_Sanctioned_No")
	private String sanctionedNo;

	@Column(name = "Emp_No")
	private int empNo; // Use long to match the bigint data type in the referenced table

	
	
	
	
	@Column(name = "Designation")
	private String designation;


	@Column(name = "Reference_No")
	private String referenceNo;
	
	@Column(name = "Emp_Name")
	private String empname;
	
	
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	@Column (name="status")
	private String status;
	

	@Column (name="Join_Date")
	private Date jionDate;
	

	public Date getJionDate() {
		return jionDate;
	}

	public void setJionDate(Date jionDate) {
		this.jionDate = jionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSanctionedNo() {
		return sanctionedNo;
	}

	public void setSanctionedNo(String sanctionedNo) {
		this.sanctionedNo = sanctionedNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int string) {
		this.empNo = string;
	}

	

	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	
	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	

	public InwardDetails getInwardDetails() {
		return parent;
	}

	public void setInwardDetails(InwardDetails inwardDetails) {
		this.parent = inwardDetails;
	}

	@ManyToOne
	@JoinColumn(name = "Emp_No", referencedColumnName = "Emp_No", insertable = false, updatable = false)
	private EmpDetails empDetails;

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

	@ManyToOne
	@JoinColumn(name = "Reference_No", referencedColumnName = "Reference_No", insertable = false, updatable = false)
	private InwardDetails parent;
	
	
	

   
}
