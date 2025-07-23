package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oracle.exceptions.NoSuchCustomerException;
import com.oracle.exceptions.DuplicateEntityException;
import com.oracle.model.Customer;
import com.oracle.service.CustomerService;

@RestController
@RequestMapping(path = "customer-api")
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    // CREATE
    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer cust) {
        service.addCustomer(cust);
        return new ResponseEntity<>("Customer added successfully!", HttpStatus.CREATED);
    }

    // READ (by email)
    @GetMapping("/email/{emailId}")
    public Customer getCustomerByEmail(@PathVariable("emailId") String email) {
        return service.findCustomerByEmail(email);
    }

    // READ (all)
    @GetMapping (path="/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return service.findAllCustomers();
    }

    // UPDATE
    @PutMapping
    public void updateCustomer(@RequestBody Customer cust) {
        service.updateCustomer(cust);
    }

    // DELETE
    @DeleteMapping("/{email}")
    public void deleteCustomer(@PathVariable String email) {
        service.deleteCustomer(email);
    }

    // --- Exception Handlers ---

    @ExceptionHandler(NoSuchCustomerException.class)
    public ResponseEntity<String> handleNoSuchCustomerException(NoSuchCustomerException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntityException.class)
    public ResponseEntity<String> handleDuplicateEntityException(DuplicateEntityException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409 Conflict
    }
}
