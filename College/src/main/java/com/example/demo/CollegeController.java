package com.example.demo;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class CollegeController {
	
	
	@Autowired
	private CollegeService service;
	
	//Retrieve All
	@GetMapping("/college")
	public List<College> readAll(){
		return service.listAll();
	}
	
	//create 
	@PostMapping("/college")
	public void add(@RequestBody College college) 
	{
		service.create(college);
	}
	
	//delete 
	@DeleteMapping("/college/{id}")
	public void delete(@PathVariable Integer id) 
	{
		service.remove(id);
	}
	
	
	//Retrieve single value
	@GetMapping("/college/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id )
	{
		try 
		{
			College college=service.get(id);
		return new ResponseEntity<College> (college,HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<College> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	//update
	@PutMapping("/college/{id}")
	public ResponseEntity<?> update(@RequestBody College college, @PathVariable Integer id)
	{
		try 
		{
			
			College existCollege = service.get(id);
			service.create(college);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
