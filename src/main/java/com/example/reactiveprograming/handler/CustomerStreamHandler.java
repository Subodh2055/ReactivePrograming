package com.example.reactiveprograming.handler;

import com.example.reactiveprograming.dao.CustomerDao;
import com.example.reactiveprograming.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Subodh Bhandari on 6/27/2023
 */

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerDao dao;

    public Mono<ServerResponse> getCustomers(ServerRequest request) {
        Flux<Customer> customerStream = dao.getCustomerStream();
        return ServerResponse.ok().body(customerStream, Customer.class);

    }
}
