package com.bootcamp.msCreditcard.services.impl;

import com.bootcamp.msCreditcard.models.entities.CreditCardCustomer;
import com.bootcamp.msCreditcard.repositories.CreditCardCustomerRepository;
import com.bootcamp.msCreditcard.services.ICreditCardCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardCustomerServiceImpl implements ICreditCardCustomerService {

    @Autowired
    private CreditCardCustomerRepository repository;

    @Override
    public Mono<CreditCardCustomer> create(CreditCardCustomer o) {
        return repository.save(o);
    }

    @Override
    public Flux<CreditCardCustomer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CreditCardCustomer> findById(String s) {
        return repository.findById(s);
    }

    @Override
    public Mono<CreditCardCustomer> update(String s, CreditCardCustomer o) {
        return repository.findById(s).flatMap( c -> {
            if (c == null){
                return null;
            }
            c.setCustomer(o.getCustomer());
            c.setCredit(o.getCredit());

            return Mono.just(c);
        });
    }

    @Override
    public Mono<Void> delete(CreditCardCustomer o) {
        return repository.delete(o);
    }
}
