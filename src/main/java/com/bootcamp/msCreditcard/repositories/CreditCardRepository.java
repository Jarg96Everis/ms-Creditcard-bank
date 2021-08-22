package com.bootcamp.msCreditcard.repositories;

import com.bootcamp.msCreditcard.models.entities.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * The interface Credit card repository.
 */
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard,String> {
    /**
     * Find by pan mono.
     *
     * @param pan the pan
     * @return the mono
     */
    Mono<CreditCard> findByPan (String pan);

    Mono<CreditCard> findByCustomer_CustomerIdentityNumber(String customerIdentityNumber);
}
