package com.crud.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.model.EmpDetails;
import com.crud.springboot.model.EmpLeaveType;
@Repository
public interface LeaveTypeRepositrory extends JpaRepository<EmpLeaveType,Long>{
	List<EmpLeaveType> findByParent(InwardDetails parent);
	 List<EmpLeaveType> findByempNo(Integer empNo);
	 
	 //EmpLeaveType findByleaveNo(Integer empno);

	EmpLeaveType findByEmpDetailsAndLeaveSubtype(EmpDetails employee, String leaveSubtype);
}