package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class jdbcConfig {
	
	@Bean("dbConfig")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Nirvi@30042021");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	//If I don't want to use the manual implementation of Bean declration. 
	//I want to use @Autowired features, then in that case comment the below code
//	@Bean("stdDaoImpl")
//	public StudentDao getStudentDao() {
//		StudentDaoImpl stdDaoImpl = new StudentDaoImpl();
//		stdDaoImpl.setJdbcTemplate(getJdbcTemplate());
//		return stdDaoImpl;
//	}
	
}
