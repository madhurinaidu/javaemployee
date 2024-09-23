package com.crud.springboot.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Grivienceentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate strategy for your database
	private int id;

	@Column(name = "GrivienceNo")

	private String GrivienceNo;
	@Column(name = "fromdate")

	private Date fromdate;

	@Column(name = "todate")
	private Date todate;
	
	@Column(name = "InwardNo")

	private int InwardNo;
	

	
	public int getInwardNo() {
		return InwardNo;
	}

	public void setInwardNo(int inwardNo) {
		InwardNo = inwardNo;
	}

	@Column(name = "EmpNo")
	private int EmpNo;

	@Column(name = "InwardDate")
	private LocalDate inwarddate;

	public LocalDate getInwarddate() {
		return inwarddate;
	}

	public void setInwarddate(LocalDate inwarddate) {
		this.inwarddate = inwarddate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public int getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(int empNo) {
		EmpNo = empNo;
	}

	public Grivienceentity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grivienceentity(String grivienceNo, Date fromdate, Date todate) {
		super();
		GrivienceNo = grivienceNo;
		this.fromdate = fromdate;
		this.todate = todate;
	}

	public String getGrivienceNo() {
		return GrivienceNo;
	}

	public void setGrivienceNo(String grivienceNo) {
		GrivienceNo = grivienceNo;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	// TODO Auto-generated method stub

}
