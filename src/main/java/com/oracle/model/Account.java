package com.oracle.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component("account1")
@Scope(scopeName = "prototype")
@Primary
@Entity
@Table(name="myaccount2")
public class Account {
	@Id
	@Column(name="acc_id")
	private int accountId;
	
	@Column(name="balance")
	private double balance;

	public Account() {
		System.out.println("Account object is created.");
		;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}
	
}
