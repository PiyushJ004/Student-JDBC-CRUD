package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentDetails;
import com.example.demo.repo.StudentRepo;

@Service("studentService")
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;

	public List<StudentDetails> getStudents() {
		List<StudentDetails> students = studentRepo.getStudents();
		return students;
	}
	

	public StudentDetails getStudent(Long studentId) {
		StudentDetails student = studentRepo.getStudent(studentId);
		return student;
	}
	

	public int deleteStudent(Long studentId) {
		return studentRepo.deleteStudent(studentId);
	}
	

	public int updateStudent(StudentDetails student) {
		return studentRepo.updateStudent(student);
	}
	

	public int createStudent(StudentDetails student) {
		return studentRepo.createStudent(student);
	}
}