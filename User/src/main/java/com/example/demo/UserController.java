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
@CrossOrigin(allowedHeaders ="*",origins="*")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	//Retrieve All
	@GetMapping("/user")
	public List<User> readAll(){
		return service.listAll(); 
	}
	
	//create 
	@PostMapping("/user")
	public void add(@RequestBody User user) 
	{
		service.create(user);
	}
	
	//delete 
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Integer id) 
	{
		service.remove(id);
	}
	
	
	//Retrieve single value
	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id )
	{
		try 
		{
			User user=service.get(id);
		return new ResponseEntity<User> (user,HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<User> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	//update
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id)
	{
		try 
		{
			
			User existUser = service.get(id);
			service.create(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
