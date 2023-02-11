package com.gagan.springcms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gagan.springcms.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customer = theQuery.getResultList();
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getcustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Customer getCustomer = currentSession.get(Customer.class, theId);

		return getCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		currentSession.delete(theCustomer);
	/*	Query theQuery =currentSession.createQuery("delete from Customer where id:= theCustomerId");
		theQuery.setParameter("theCutomerId", theId);
		theQuery.executeUpdate();*/
	}

}
