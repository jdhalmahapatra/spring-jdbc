package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;


@Component("stdDaoImpl")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}
	
	//I also can use the @Autowired features on top of Setter method, 
	//constructor, and Property Variable
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public int insert(Student student) {
		// Insert Query
		 String query = "insert into "
	        		+ "student (id, name, city) "
	        		+ "values (?, ?, ?)";
		 int result = this.jdbcTemplate.update(query, 
				 student.getId(), student.getName(), student.getCity());
		return result;
	}



	public int updateRecord(Student student) {
		// update query
		String query = "update student set name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query, 
				student.getName(), student.getCity(), student.getId());
		return result;
	}



	public int deleteRecord(int id) {
		// Delete Query
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query, id);
		return result;
	}



	public Student getStudentbyId(int id) {
		// Select Single Student Data
		String qeury = "select * from student where id=?";
		RowMapper<Student> rowMapper = new StudentRowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(qeury, rowMapper, id);
		return student;
	}



	public List<Student> getAllStudents() {
		// Select Multiple Student Objects
		String query = "select * from student";
		
		List<Student> students = this.jdbcTemplate.query(query, new StudentRowMapperImpl());
		return students;
	}

}
