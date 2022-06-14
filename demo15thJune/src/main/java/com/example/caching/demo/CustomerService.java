package com.example.caching.demo;

public interface CustomerService {
	Customer getCustomer(final String customerID) throws Exception;
}
