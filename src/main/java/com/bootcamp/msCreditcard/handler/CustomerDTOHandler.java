package com.bootcamp.msCreditcard.handler;

import com.bootcamp.msCreditcard.entities.CustomerDTO;
import com.bootcamp.msCreditcard.services.ICustomerDTOService;
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

@Slf4j(topic = "customerdt_handler")
@Component
public class CustomerDTOHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDTOHandler.class);

    @Autowired
    private ICustomerDTOService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), CustomerDTO.class);
    }

    public Mono<ServerResponse> findCustomerDTO(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id).flatMap((c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(c))
                .switchIfEmpty(ServerResponse.notFound().build()))
        );
    }

    public Mono<ServerResponse> newCustomerDTO(ServerRequest request){

        Mono<CustomerDTO> customerDTOMono = request.bodyToMono(CustomerDTO.class);

        return customerDTOMono.flatMap( c -> service.create(c)).flatMap( c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(c)));
    }

    public Mono<ServerResponse> deleteCustomerDTO(ServerRequest request){

        String id = request.pathVariable("id");

        Mono<CustomerDTO> customerDTOMono = service.findById(id);

        return customerDTOMono
                .doOnNext(c -> LOGGER.info("deleteConsumption: consumptionId={}", c.getId()))
                .flatMap(c -> service.delete(c).then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateCustomerDTO(ServerRequest request){
        Mono<CustomerDTO> customerDTOMono = request.bodyToMono(CustomerDTO.class);
        String id = request.pathVariable("id");

        return service.findById(id).zipWith(customerDTOMono, (db,req) -> {
                    db.setName(req.getName());
                    db.setSurname(req.getSurname());
                    db.setCustomerType(req.getCustomerType());
                    return db;
                }).flatMap( c -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.create(c),CustomerDTO.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
