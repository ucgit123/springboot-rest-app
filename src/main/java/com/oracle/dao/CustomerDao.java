package com.oracle.dao;

import java.util.List;
import com.oracle.model.Customer;

public interface CustomerDao {
    void createCustomer(Customer cust);                 // Create
    Customer readCustomerByEmail(String email);         // Read by email
    List<Customer> readAllCustomers();                  // Read all
    void updateCustomer(Customer cust);                 // Update
    void deleteCustomer(String email);                  // Delete
}
