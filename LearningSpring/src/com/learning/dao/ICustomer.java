package com.learning.dao;

import java.util.List;

import com.learning.model.Customer;

public interface ICustomer {
	/**
	 * save customer
	 * @param customer
	 * @return 
	 */
	Boolean saveCustomer(Customer customer);
	/**
	 *  view customers
	 * @return
	 */
	List<Customer> viewCustomers();

}
