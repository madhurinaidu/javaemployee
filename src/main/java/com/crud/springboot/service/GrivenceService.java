package com.crud.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springboot.model.Grivienceentity;
import com.crud.springboot.repo.Griviencerepo;
@Service
public class GrivenceService {
	@Autowired
	Griviencerepo griviencerepo;
	


}
