package com.masai.app1;

import javax.persistence.Entity;
import javax.persistence.Id;
//it is entity or percistence class;
@Entity
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

	@Id
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
