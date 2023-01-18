package com.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.Course;
import com.platform.entity.Student;
import com.platform.repository.CourseRepo;
import com.platform.repository.StudentRepo;

@RestController
@RequestMapping("/platform/admin")
public class AdminController {

	@Autowired
	private StudentRepo studentRepo;

	@PostMapping("/registerStudent")
	private ResponseEntity<Student> registerStudent(@RequestBody Student student){
		
		Student savedStudent = studentRepo.save(student);
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
	}
	
}
