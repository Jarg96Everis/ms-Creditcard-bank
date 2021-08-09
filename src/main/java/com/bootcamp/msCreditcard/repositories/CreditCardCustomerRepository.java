package com.bootcamp.msCreditcard.repositories;

import com.bootcamp.msCreditcard.models.entities.CreditCardCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditCardCustomerRepository extends ReactiveMongoRepository<CreditCardCustomer,String> {
}
