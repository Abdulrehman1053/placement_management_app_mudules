package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{
	private Integer id;
	private String name;
	private String type;
	private Integer Password;
	
	
	//Parametrized Contructor
	public User(Integer id, String name, String type, Integer password) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		Password = password;
	}

	//Parametrized Contructor
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//getter and setter method 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPassword() {
		return Password;
	}

	public void setPassword(Integer password) {
		Password = password;
	}
	
	//to string method 

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", Password=" + Password + "]";
	}
	

	

	

	
	
	
	
}
