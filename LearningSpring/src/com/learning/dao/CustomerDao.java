package com.learning.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.learning.model.Customer;

public class CustomerDao implements ICustomer {
	JdbcTemplate jTemplate;

	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}
	
	@Autowired
	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	@Override
	public Boolean saveCustomer(Customer customer) {
		String sql="Insert into customer(CUST_ID,NAME,AGE)values("+customer.getId()+",'"+customer.getName()+"',"+customer.getAge()+");";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return null;
		
	}

	@Override
	public List<Customer> viewCustomers() {
		return this.jTemplate.query("select * from customer", new RowMapper<Customer>()
		{

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Customer m=new Customer();
				m.setId(rs.getInt(0));
				m.setName(rs.getString(1));
				m.setAge(rs.getInt(2));
				return m;
			}
			
		});
	}

}
