package com.bootcamp.msCreditcard.models.entities;

import com.bootcamp.msCreditcard.models.dto.CustomerDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditcardcustomer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardCustomer {

    @Id
    private String id;

    private CreditCard credit;

    private CustomerDTO customer;
}
