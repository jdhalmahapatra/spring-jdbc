package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//Spring jdbc =>  JdbcTemplate
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); 
        
        StudentDao stdDao = context.getBean("stdDaoImpl", StudentDao.class);
        Scanner scanner = new Scanner(System.in);
        
        //1. INSERT: For Inserting new Record
        Student std2 = new Student();
        
        std2.setId(69);
        std2.setName("Sohan");
        std2.setCity("Pune");
        int result = stdDao.insert(std2);
        
        //2. UPDATE: For Updating new Record
//        Student std1 = new Student();
//        std1.setId(55);
//        std1.setName("Akash");
//        std1.setCity("Mumbai");
//       
//        int result = stdDao.updateRecord(std1);
        
        
        //3. DELETE: For Delting existing record
        
//        int idToDelete = scanner.nextInt();
//        int result = stdDao.deleteRecord(idToDelete);
        
        System.out.println("No of record affected " + result);
        
        
        //4. SELECT: for Single Data Query
        Student std = stdDao.getStudentbyId(3);
        System.out.println(std);
        
        //5. SELECT: For Multiple Records
        List<Student> allStudents = stdDao.getAllStudents();
        for(Student s: allStudents) {
        	System.out.println(s);
        }
        
        
        ((ClassPathXmlApplicationContext)context).close();
       
    }
}
