package com.oracle.service;

import java.util.List;
import com.oracle.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.oracle.dao.CustomerDao;
import com.oracle.exceptions.NoSuchCustomerException;
import com.oracle.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	public void addCustomer(Customer cust) {
	    Customer existingCustomer = dao.readCustomerByEmail(cust.getEmail());
	    if (existingCustomer != null) {
	        throw new DuplicateEntityException("Customer with email: " + cust.getEmail() + " already exists.");
	    }

	    try {
	        dao.createCustomer(cust);
	    } catch (DataIntegrityViolationException ex) {
	        throw new DuplicateEntityException("Duplicate email detected: " + cust.getEmail(), ex);
	    }
	}


	@Override
	public Customer findCustomerByEmail(String email) {
		Customer customer = dao.readCustomerByEmail(email);
		if (customer == null) {
			throw new NoSuchCustomerException("Customer with email: " + email + " not found.");
		}
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return dao.readAllCustomers();
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
	}

	@Override
	public void deleteCustomer(String email) {
		dao.deleteCustomer(email);
	}
}
