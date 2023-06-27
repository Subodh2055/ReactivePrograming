package com.example.reactiveprograming.controller;

import com.example.reactiveprograming.dto.Customer;
import com.example.reactiveprograming.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author Subodh Bhandari on 6/27/2023
 */

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerService.loadAllCustomer();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return customerService.loadAllCustomerStream();
    }
}
