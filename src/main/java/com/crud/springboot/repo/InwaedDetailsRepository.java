package com.crud.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.model.EmpLeaveType;
@Repository
public interface InwaedDetailsRepository extends JpaRepository<InwardDetails,Integer> {

	List<InwardDetails> findByRequestType(String requesttype);
	List<InwardDetails> findByempNo(Integer empno);
	List<InwardDetails> findBystatus(String status);
	List<InwardDetails>findBystatusAndRequestType(String status,String requestType);
	List<InwardDetails> findByempNoAndStatus(Integer empno,String status);
	
}
