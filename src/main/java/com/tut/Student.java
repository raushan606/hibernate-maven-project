package com.tut;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "mystudents")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	
	private Certificate certi;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(String name, String city) {
		super();
		
		this.name = name;
		this.city = city;
	}
	
	



	public Certificate getCerti() {
		return certi;
	}



	public void setCerti(Certificate certi) {
		this.certi = certi;
	}



	public int getId() {
		return id;
	}






	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+" "+this.name+" "+this.city;
	}
	
	
	
	
	
	
}
