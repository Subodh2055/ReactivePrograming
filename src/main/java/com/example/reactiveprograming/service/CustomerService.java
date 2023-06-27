package com.example.reactiveprograming.service;

import com.example.reactiveprograming.dao.CustomerDao;
import com.example.reactiveprograming.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author Subodh Bhandari on 6/27/2023
 */

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomer() {
        Long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomer();
        Long end = System.currentTimeMillis();
        System.out.println("Total time execution: " + (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomerStream() {
        Long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomerStream();
        Long end = System.currentTimeMillis();
        System.out.println("Total time execution: " + (end - start));
        return customers;
    }
}
