package com.bootcamp.msCreditcard.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "creditcard")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCard {

    @Id
    private String id;

    private String pan;

    private String cardType;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createAt;

    private String cardBran;

    private double creditLimit;

    private double totalConsumption;

    private CustomerDTO customer;

    private int settlementDay;

    private int chargeDay;
}
