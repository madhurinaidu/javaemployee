package com.crud.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inward_Details")
public class InwardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Inid")
	private int inid;

	

	@Column(name = "Inward_No")
	private int inwardNo;

	@Column(name = "Reference_No", unique = true)
	private String referenceNo;

	@Column(name = "Grevience_No", unique = true)
	private String grevianceNo;

	@Column(name = "Emp_No")
	private int empNo;

	@Column(name = "Emp_Desig")
	private String empDesig;

	@Column(name = "Request_Type")
	private String requestType;

	@Column(name = "Request_Subtype")
	private String requestSubtype;

	@Column(name = "Inward_Date")
	private LocalDate inwardDate;

	@Column(name = "Greviance_Date")
	private LocalDate grevianceDate;

	@Column(name = "Status")
	private String status;

	@Column(name = "Remarks")
	private String remarks;

	@ManyToOne
	@JoinColumn(name = "Emp_No", referencedColumnName = "Emp_No", insertable = false, updatable = false)
	private EmpDetails empDetails;

	@ManyToOne
	@JoinColumn(name = "leaveNo")
	private EmpLeaveType leaveType;

	public EmpLeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(EmpLeaveType leaveType) {
		this.leaveType = leaveType;
	}

	// Default constructor
	public InwardDetails() {

	}

	public InwardDetails(int inwardNo, int i, String requestType, int j, String status, String string, String string2,
			String string3, String string4, String string5, String string6, int k) {
		this.inwardNo = inwardNo;
		this.requestType = requestType;
		this.status = status;
	}

	// Constructor with necessary parameters
	public InwardDetails(int inwardNo, String grevianceNo, int empNo, String empDesig, String requestType,
			String requestSubtype, LocalDate inwardDate, LocalDate grevianceDate, String status, String remarks,
			String referenceNo, EmpDetails empDetails, EmpLeaveType leaveType) {
		this.inwardNo = inwardNo;
		this.grevianceNo = grevianceNo;
		this.empNo = empNo;
		this.empDesig = empDesig;
		this.requestType = requestType;
		this.requestSubtype = requestSubtype;
		this.inwardDate = inwardDate;
		this.grevianceDate = grevianceDate;
		this.status = status;
		this.remarks = remarks;
		this.referenceNo = referenceNo;
		this.empDetails = empDetails;
		this.leaveType = leaveType;
	}

	public InwardDetails(int i, int j, String string, int k, String string2, String string3, String string4, int l,
			int m, String string5, String string6, int n) {
		// TODO Auto-generated constructor stub
	}

	public int getInwardNo() {
		return inwardNo;
	}

	public void setInwardNo(int inwardNo) {
		this.inwardNo = inwardNo;
	}

	public String getGrevianceNo() {
		return grevianceNo;
	}

	public void setGrevianceNo(String grevianceNo) {
		this.grevianceNo = grevianceNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpDesig() {
		return empDesig;
	}

	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestSubtype() {
		return requestSubtype;
	}

	public void setRequestSubtype(String requestSubtype) {
		this.requestSubtype = requestSubtype;
	}

	public LocalDate getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(LocalDate localDate) {
		this.inwardDate = localDate;
	}

	public LocalDate getGrevianceDate() {
		return grevianceDate;
	}

	public void setGrevianceDate(LocalDate localDate) {
		this.grevianceDate = localDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}
	public int getInid() {
		return inid;
	}

	public void setInid(int inid) {
		this.inid = inid;
	}

}
