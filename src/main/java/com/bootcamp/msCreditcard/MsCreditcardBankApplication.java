package com.bootcamp.msCreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The type Ms creditcard bank application.
 */
@SpringBootApplication
@EnableEurekaClient
public class MsCreditcardBankApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(MsCreditcardBankApplication.class, args);
	}

}
