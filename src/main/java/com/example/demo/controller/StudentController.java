package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentDetails;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	
	
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<StudentDetails>> students() {

		List<StudentDetails> students = studentService.getStudents();

		if (students == null) {
			return new ResponseEntity<List<StudentDetails>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StudentDetails>>(students, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDetails> getStudent(@PathVariable("id") Long studentId) {
		StudentDetails student = studentService.getStudent(studentId);
		if (student == null) {
			return new ResponseEntity<StudentDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentDetails>(student, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentDetails> deleteStudent(@PathVariable("id") Long studentId) {

		StudentDetails student = studentService.getStudent(studentId);
		if (student == null) {
			return new ResponseEntity<StudentDetails>(HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudent(studentId);
		return new ResponseEntity<StudentDetails>(student, HttpStatus.NO_CONTENT);
	}
	
	

	@RequestMapping(value = "/student", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<StudentDetails> createStudent(@RequestBody StudentDetails student) {

		if (student == null) {
			return new ResponseEntity<StudentDetails>(HttpStatus.BAD_REQUEST);
		}
		studentService.createStudent(student);
		return new ResponseEntity<StudentDetails>(student, HttpStatus.CREATED);
	}
	
	

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentDetails> updateStudent(@PathVariable("id") Long studentId,
			@RequestBody StudentDetails student) {

		StudentDetails st = studentService.getStudent(studentId);
		if (st == null) {
			return new ResponseEntity<StudentDetails>(HttpStatus.NOT_FOUND);
		} else if (student == null) {
			return new ResponseEntity<StudentDetails>(HttpStatus.BAD_REQUEST);
		}
		studentService.updateStudent(student);
		return new ResponseEntity<StudentDetails>(student, HttpStatus.OK);
	}
}
