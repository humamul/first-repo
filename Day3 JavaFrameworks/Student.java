package com.masai.app1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//it is entity or percistence class;
@Entity
@Table(name = "meriTable") // now the name of the table will be meriTable

public class Student { 
	
	Student (){
		
	}
	public Student(int roll, int marks, String name) {
		super();
		this.roll = roll;
		this.marks = marks;
		this.name = name;
	}
//Unique things

	@Id   //it will be primary key based on it the update property in xml or there can be create in property so it will drop a table and create a new one again and again;
	@Column(name= "sroll")//for any column of the table
	private int roll;  //unique id
	
	
	
	
	private int marks;
	
	
	private String name;
	public int getMarks() {
		return marks;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
