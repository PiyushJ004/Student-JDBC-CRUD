package com.example.demo.repo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentDetails;

@Repository("studentrepo")
public class StudentRepo {

	private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	 
	 
	 public List<StudentDetails> getStudents() {
	  List<StudentDetails> student = null ;
	  
	  try {
	   student = jdbcTemplate.query("SELECT * FROM student",new BeanPropertyRowMapper<StudentDetails>(StudentDetails.class));
	  } catch (DataAccessException e) {
	   e.printStackTrace();
	  }
	  return student;
	 }
	 
	 
	 
	 public StudentDetails getStudent(Long studentId) {
	  StudentDetails student = null;
	  try {
	   student = jdbcTemplate.queryForObject("SELECT * FROM student WHERE student_id = ?",
	     new Object[] { studentId }, new BeanPropertyRowMapper<StudentDetails>(StudentDetails.class));
	  } catch (DataAccessException e) {
	   e.printStackTrace();
	  }
	  return student;
	 }
	 
	 
	 
	 public int deleteStudent(Long studentId) {
	  int count = jdbcTemplate.update("DELETE from student WHERE student_id = ?", new Object[] { studentId });
	  return count;
	 }
	 
	 
	 
	 public int updateStudent(StudentDetails student) {
	  int c = jdbcTemplate.update(
	    "UPDATE student set first_name = ? , last_name = ? , age = ? where student_id = ?", new Object[] {
	      student.getFirstName(), student.getLastName(), student.getAge(), student.getStudentId() });
	  return c;
	 }
	 
	 
	 
	 public int createStudent(StudentDetails student) {
	  int c = jdbcTemplate.update(
	    "INSERT INTO student(student_id,first_name, last_name, age)VALUES(?,?,?,?)", new Object[] {
	      student.getStudentId(), student.getFirstName(), student.getLastName(), student.getAge() });
	  return c;
	 }
	 
	}
