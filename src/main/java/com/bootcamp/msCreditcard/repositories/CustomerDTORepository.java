package com.bootcamp.msCreditcard.repositories;

import com.bootcamp.msCreditcard.entities.CustomerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerDTORepository extends ReactiveMongoRepository<CustomerDTO,String> {
}
