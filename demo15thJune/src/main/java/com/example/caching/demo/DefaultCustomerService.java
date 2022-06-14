package com.example.caching.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = {"customer"})
public class DefaultCustomerService implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCustomerService.class);

   // @Cacheable
    @Cacheable(value = "customer")
    @Override
    public Customer getCustomer(String customerID){
        LOG.info("Trying to get customer information for id {} ",customerID);
       // throw new Exception("game of fixing............");
        return getCustomerData(customerID);
    }

    private Customer getCustomerData(final String id){
        Customer customer = new Customer(id, "testemail@test.com", "Test Customer");
        return  customer;
    }
}