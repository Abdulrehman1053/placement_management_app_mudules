package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class College {
	
	
	private Integer id;
	private String name;  
	private String college;
	private String location;
	
	public College(Integer id, String name, String college, String location) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.location = location;
	}

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", college=" + college + ", location=" + location + "]";
	}
	
	
}
