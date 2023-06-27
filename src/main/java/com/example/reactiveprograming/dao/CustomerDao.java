package com.example.reactiveprograming.dao;

import com.example.reactiveprograming.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Subodh Bhandari on 6/27/2023
 */

@Component
public class CustomerDao {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDao::sleepExecution)
                .peek(i -> System.out.println("processing count" + i))
                .mapToObj(i -> new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count in stream flow : 0" + i))
                .map(i -> new Customer(i, "customer" + i));
    }
}
