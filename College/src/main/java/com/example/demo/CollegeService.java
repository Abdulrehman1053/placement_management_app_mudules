package com.example.demo;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class CollegeService {
	
	@Autowired
	private CollegeRepository repo;
	
	

	//Retrieve
	public List<College> listAll()
	{
		return repo.findAll();
	}
	
	//Retrieve single data 
	public College get(Integer id) 
	{
		return repo.findById(id).get();
		
	}
	
	//Create & Update
	
	public void create(College college) 
	{
		repo.save(college);
		
	}
	
	//delete
	
	public void remove(Integer id) 
	{
		repo.deleteById(id);
	}
	

}
