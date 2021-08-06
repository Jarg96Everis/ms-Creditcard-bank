package com.bootcamp.msCreditcard.repositories;

import com.bootcamp.msCreditcard.entities.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard,String> {
}