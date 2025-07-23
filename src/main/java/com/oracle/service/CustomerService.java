package com.oracle.service;

import java.util.List;
import com.oracle.model.Customer;

public interface CustomerService {
    void addCustomer(Customer cust);                   // Create
    Customer findCustomerByEmail(String email);        // Read by ID
    List<Customer> findAllCustomers();                 // Read all
    void updateCustomer(Customer cust);                // Update
    void deleteCustomer(String email);                 // Delete
}
