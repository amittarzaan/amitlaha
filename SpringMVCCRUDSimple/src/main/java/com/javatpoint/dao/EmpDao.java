package com.javatpoint.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.javatpoint.beans.Emp;  
  
public class EmpDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Emp p){  
    //String sql="insert into SPRING_EMPLOYEE(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')"; 
    String sql="insert into SPRING_EMPLOYEE(name,salary,designation) values('laha',100,'dev')";
    System.out.println("SQL :: "+sql);
    return template.update(sql);
}  
public int update(Emp p){  
    String sql="update SPRING_EMPLOYEE set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from SPRING_EMPLOYEE where id="+id+"";  
    return template.update(sql);  
}  
public Emp getEmpById(int id){  
    String sql="select * from SPRING_EMPLOYEE where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}  
public List<Emp> getEmployees(){  
    return template.query("select id,name,salary,designation from SPRING_EMPLOYEE",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
			/*
			 * e.setId(rs.getInt(1)); e.setName(rs.getString(2));
			 * e.setSalary(rs.getFloat(3)); e.setDesignation(rs.getString(4));
			 */ 
            e.setId(Integer.parseInt(rs.getString("id")));
            e.setName(rs.getString("name"));
			e.setSalary(Float.parseFloat(rs.getString("salary")));
			e.setDesignation(rs.getString("designation"));
            return e;  
        }  
    });  
}  
}  