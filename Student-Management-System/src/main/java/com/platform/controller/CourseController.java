package com.platform.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.Course;
import com.platform.exception.CourseException;
import com.platform.exception.StudentException;
import com.platform.payloads.request.CourseDTO;
import com.platform.payloads.request.StudentAuthenticationRequest;
import com.platform.payloads.response.CourseAssignedResponse;
import com.platform.payloads.response.CourseWithStudentsResponse;
import com.platform.payloads.response.StudentWithCoursesResponse;
import com.platform.repository.CourseRepo;
import com.platform.service.CourseService;

@RestController
@RequestMapping("/platform/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/register")
	public ResponseEntity<CourseDTO> registerCourse(@RequestBody CourseDTO course) throws CourseException{
		
		CourseDTO savedCourse = this.courseService.uploadCourse(course);
		return new ResponseEntity<CourseDTO>(savedCourse,HttpStatus.CREATED);
	}
	@PutMapping("/update")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO course,@RequestParam Integer course_id) throws CourseException{
		
		CourseDTO savedCourse = this.courseService.updateCourse(course_id, course);
		return new ResponseEntity<CourseDTO>(savedCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{courseId}")
    public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Integer courseId) throws CourseException{
		
		CourseDTO savedCourse = this.courseService.deleteCourse(courseId);
		return new ResponseEntity<CourseDTO>(savedCourse,HttpStatus.OK);
	}
	
	@PutMapping("/assign")
	public ResponseEntity<CourseAssignedResponse> assignCourseToStudent(@RequestParam Integer courseId,@RequestParam Integer studentCode) throws CourseException, StudentException{
		
		CourseAssignedResponse savedCourse = this.courseService.assignCourseToStudent(courseId,studentCode);
		return new ResponseEntity<CourseAssignedResponse>(savedCourse,HttpStatus.OK);
	}
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseWithStudentsResponse> getStudentsByCourse(@PathVariable("courseId") Integer courseId) throws StudentException, CourseException{
		CourseWithStudentsResponse studentByName = courseService.getStudentByCourseId(courseId);
		return new ResponseEntity<CourseWithStudentsResponse>(studentByName,HttpStatus.OK);
	}
	@GetMapping("/getTopics")
	public ResponseEntity <List<String>> getTopicsAssigned(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,@RequestParam Integer studentCode) throws CourseException, StudentException{

		List<String> allTopicsAssigned = this.courseService.getAllTopicsAssigned(new StudentAuthenticationRequest(studentCode, dateOfBirth));
		return new ResponseEntity<List<String>>(allTopicsAssigned,HttpStatus.OK);
	}
	
}
