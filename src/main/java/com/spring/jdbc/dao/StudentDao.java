package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public int updateRecord(Student student);
	public int deleteRecord(int id);
	public Student getStudentbyId(int id);
	public List<Student> getAllStudents();
}
