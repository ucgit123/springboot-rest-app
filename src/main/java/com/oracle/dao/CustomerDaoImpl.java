package com.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void createCustomer(Customer cust) {
        entityManager.persist(cust); // INSERT
    }

    @Override
    public Customer readCustomerByEmail(String email) {
        return entityManager.find(Customer.class, email); // SELECT
    }

    @Override
    public List<Customer> readAllCustomers() {
        String jpql = "FROM Customer";
        //Alter: String jpql = "SELECT c FROM Customer c";
        return entityManager.createQuery(jpql, Customer.class).getResultList();
    }

    @Override
    @Transactional
    public void updateCustomer(Customer cust) {
        entityManager.merge(cust); // UPDATE
    }

    @Override
    @Transactional
    public void deleteCustomer(String email) {
        Customer cust = entityManager.find(Customer.class, email);
        if (cust != null) {
            entityManager.remove(cust); // DELETE
        }
    }
}
