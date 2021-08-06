package com.bootcamp.msCreditcard.services.impl;

import com.bootcamp.msCreditcard.entities.CustomerDTO;
import com.bootcamp.msCreditcard.repositories.CustomerDTORepository;
import com.bootcamp.msCreditcard.services.ICustomerDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerDTOServiceImpl implements ICustomerDTOService {

    @Autowired
    private CustomerDTORepository repository;

    @Override
    public Mono<CustomerDTO> create(CustomerDTO o) {
        return repository.save(o);
    }

    @Override
    public Flux<CustomerDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CustomerDTO> findById(String s) {
        return repository.findById(s);
    }

    @Override
    public Mono<CustomerDTO> update(String s, CustomerDTO o) {
        return repository.findById(s).flatMap( c -> {
            if (c == null){
                return null;
            }
            c.setName(o.getName());
            c.setSurname(o.getSurname());
            c.setCustomerType(o.getCustomerType());

            return Mono.just(c);
        });
    }

    @Override
    public Mono<Void> delete(CustomerDTO o) {
        return repository.delete(o);
    }
}
