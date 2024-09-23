package com.crud.springboot.model;

import java.sql.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emp_Details")
public class EmpDetails {

	@Id
    @Column( name = "Emp_No")
    private int empNo;

	@Column(name = "Emp_Name")
	private String empName;

	@Column(name = "Join_Date")
	private Date joinDate;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Age")
	private Integer age;

	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "sickleave")
	private int sickleave;
	
	@Column(name = "persnalleave")
	private int persnalleave;
	
	@Column(name = "UserName")
	private String username;
	
	@Column(name = "Password")
	private String Password;
	
	@Column(name = "Homeloan")
	private int homeloan;
	
	@Column(name = "persnalloan")
	private int persnalloan;
	
	
	

	public int getHomeloan() {
		return homeloan;
	}



	public void setHomeloan(int homeloan) {
		homeloan = homeloan;
	}



	public int getPersnalloan() {
		return persnalloan;
	}



	public void setPersnalloan(int persnalloan) {
		this.persnalloan = persnalloan;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public int getSickleave() {
		return sickleave;
	}



	public void setSickleave(int sickleave) {
		this.sickleave = sickleave;
	}



	public int getPersnalleave() {
		return persnalleave;
	}



	public void setPersnalleave(int persnalleave) {
		this.persnalleave = persnalleave;
	}



	public EmpDetails() {

	}
	


	public EmpDetails(int empNo, String empName, Date joinDate, String designation, Integer age, String gender,int sickleave,int persnalleave) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.joinDate = joinDate;
		this.designation = designation;
		this.age = age;
		this.gender = gender;
		this.sickleave=sickleave;
		this.persnalleave=persnalleave;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}