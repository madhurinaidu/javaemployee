package com.crud.springboot.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springboot.model.EmpLeaveType;
import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.model.LeaveSanctioned;
@Repository
public interface LeaveSanctionedRepository extends JpaRepository<LeaveSanctioned,Integer>{
	List<LeaveSanctioned> findByParent(InwardDetails parent);


}

