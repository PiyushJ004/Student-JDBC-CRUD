package com.example.demo.model;
public class StudentDetails {
	private Long studentId;
	private String firstName;
	private String lastName;
	private Long age;
	
	

	public StudentDetails(Long studentId, String firstName, String lastName, Long age) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	
	
	public Long getStudentId() {
		return studentId;
	}

	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	
	
	
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}
	
	
	
	
	

}
