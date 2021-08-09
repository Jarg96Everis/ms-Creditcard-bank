package com.bootcamp.msCreditcard.handler;

import com.bootcamp.msCreditcard.models.entities.CreditCardCustomer;
import com.bootcamp.msCreditcard.services.ICreditCardCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j(topic = "creditcardcustomer_handler")
@Component
public class CreditCardCustomerHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardCustomerHandler.class);

    @Autowired
    private ICreditCardCustomerService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), CreditCardCustomer.class);
    }

    public Mono<ServerResponse> findCreditCardCustomer(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id).flatMap((c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(c))
                .switchIfEmpty(ServerResponse.notFound().build()))
        );
    }

    public Mono<ServerResponse> newCreditCardCustomer(ServerRequest request){

        Mono<CreditCardCustomer> creditCardCustomerMono = request.bodyToMono(CreditCardCustomer.class);

        return creditCardCustomerMono.flatMap( c -> service.create(c)).flatMap( c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(c)));
    }

    public Mono<ServerResponse> deleteCreditCardCustomer(ServerRequest request){

        String id = request.pathVariable("id");

        Mono<CreditCardCustomer> creditCustomerMono = service.findById(id);

        return creditCustomerMono
                .doOnNext(c -> LOGGER.info("deleteConsumption: consumptionId={}", c.getId()))
                .flatMap(c -> service.delete(c).then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateCreditCardCustomer(ServerRequest request){
        Mono<CreditCardCustomer> creditCardCustomerMono = request.bodyToMono(CreditCardCustomer.class);
        String id = request.pathVariable("id");

        return service.findById(id).zipWith(creditCardCustomerMono, (db,req) -> {
                    db.setCustomer(req.getCustomer());
                    db.setCredit(req.getCredit());
                    return db;
                }).flatMap( c -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.create(c),CreditCardCustomer.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
