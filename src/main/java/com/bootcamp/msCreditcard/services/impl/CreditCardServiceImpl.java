package com.bootcamp.msCreditcard.services.impl;

import com.bootcamp.msCreditcard.entities.CreditCard;
import com.bootcamp.msCreditcard.repositories.CreditCardRepository;
import com.bootcamp.msCreditcard.services.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardServiceImpl implements ICreditCardService {

    @Autowired
    private CreditCardRepository repository;

    @Override
    public Mono<CreditCard> create(CreditCard o) {
        return repository.save(o);
    }

    @Override
    public Flux<CreditCard> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CreditCard> findById(String s) {
        return repository.findById(s);
    }

    @Override
    public Mono<CreditCard> update(String s, CreditCard o) {
        return repository.findById(s).flatMap( c -> {
            if (c == null){
                return null;
            }
            c.setPan(o.getPan());
            c.setCardBran(o.getCardBran());
            c.setCardType(o.getCardType());
            c.setCreditLimit(o.getCreditLimit());
            c.setTotalConsumption(o.getTotalConsumption());
            c.setCustomer(o.getCustomer());
            c.setSettlementDay(o.getSettlementDay());
            c.setChargeDay(o.getChargeDay());

            return Mono.just(c);
        });
    }

    @Override
    public Mono<Void> delete(CreditCard o) {
        return repository.delete(o);
    }
}
