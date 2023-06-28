package com.example.reactiveprograming.handler;

import com.example.reactiveprograming.dao.CustomerDao;
import com.example.reactiveprograming.dto.Customer;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Subodh Bhandari on 6/27/2023
 */

@Service
public class CustomerHandler {

    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest request) {
       Flux<Customer> customerList = customerDao.getCustomerList();
       return ServerResponse.ok().body(customerList,Customer.class);
    }
}
