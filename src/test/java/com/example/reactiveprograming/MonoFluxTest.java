package com.example.reactiveprograming;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Subodh Bhandari on 6/27/2023
 */
public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("Java Subodh")
                .then(Mono.error(new RuntimeException("Expection Occured")))
                .log();
        monoString.subscribe(System.out:: println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
      Flux<String> fluxString = Flux.just("Spring ", "Spring Boot", "Hibernate", "microService")
              .concatWithValues("aws")
              .concatWith(Flux.error(new RuntimeException("Exception Error in flux")))
              .concatWithValues("cloud")
              .log();
      fluxString.subscribe(System.out:: println, (e) -> System.out.println(e.getMessage()));
    }
}
