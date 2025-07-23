package com.oracle.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name= "mycustomer2")
public class Customer {
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Id
	private String email;


	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;

	public Customer() {
		System.out.println("Customer object is created.");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", accountId="
				+ account + "]";
	}
	
	

}