package com.bootcamp.msCreditcard.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customerDTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    @Id
    private String id;

    private String idenNumber;

    private String name;

    private String surname;

    private String customerType;
}
