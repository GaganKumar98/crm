package com.gagan.springcms.dao;

import java.util.List;

import com.gagan.springcms.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getcustomer(int theId);

	public void deleteCustomer(int theId);
}
