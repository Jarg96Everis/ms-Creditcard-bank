package com.bootcamp.msCreditcard.services;

import com.bootcamp.msCreditcard.models.dto.Customer;
import com.bootcamp.msCreditcard.models.dto.CustomerDTO;
import com.bootcamp.msCreditcard.models.entities.CreditCard;
import reactor.core.publisher.Mono;

/**
 * The interface Credit card service.
 */
public interface ICreditCardService extends ICRUDService<CreditCard,String> {

    /**
     * Gets customer.
     *
     * @param customerIdentityNumber the customer identity number
     * @return the customer
     */
    public Mono<Customer> getCustomer(String customerIdentityNumber);

    /**
     * Find by pan mono.
     *
     * @param pan the pan
     * @return the mono
     */
    public Mono<CreditCard> findByPan(String pan);

    /**
     * New pan mono.
     *
     * @param id          the id
     * @param customerDTO the customer dto
     * @return the mono
     */
    public Mono<CustomerDTO> newPan(String id, CustomerDTO customerDTO);

    public Mono<CreditCard> findByCustomerIdentityNumber(String customerIdentityNumber);
}
