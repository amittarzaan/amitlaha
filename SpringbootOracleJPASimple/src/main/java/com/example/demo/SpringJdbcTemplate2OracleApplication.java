package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
 
@SpringBootApplication
public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM Student";
         
        List<Student> students = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Student.class));
         
        students.forEach(System.out :: println);

        
    }
 
}