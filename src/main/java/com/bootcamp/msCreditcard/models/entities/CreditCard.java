package com.bootcamp.msCreditcard.models.entities;

import com.bootcamp.msCreditcard.models.dto.CustomerDTO;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
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

    @NotNull
    private String pan;

    @NotNull
    private String cardType;

    @Field( name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createAt;

    @NotNull
    private String cardBran;

    @NotNull
    private String creditCardType;

    @NotNull
    private double creditLimit;

    private double totalConsumption;

    @NotNull
    private int settlementDay;

    @NotNull
    private int chargeDay;

    @NotNull
    private CustomerDTO customer;
}
