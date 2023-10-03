package com.example.demo;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	//Retrieve
	public List<User> listAll()
	{
		return repo.findAll();
	}
	
	//Retrieve single data 
	public User get(Integer id) 
	{
		return repo.findById(id).get();
		
	}
	
	//Create & Update
	
	public void create(User user) 
	{
		repo.save(user);
		
	}
	
	//delete
	
	public void remove(Integer id) 
	{
		repo.deleteById(id);
	}
	

}
