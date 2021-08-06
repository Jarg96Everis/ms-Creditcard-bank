package com.bootcamp.msCreditcard.config;

import com.bootcamp.msCreditcard.handler.CreditCardCustomerHandler;
import com.bootcamp.msCreditcard.handler.CreditCardHandler;
import com.bootcamp.msCreditcard.handler.CustomerDTOHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(CreditCardHandler creditCardHandler,
                                                 CreditCardCustomerHandler creditCardCustomerHandler,
                                                 CustomerDTOHandler customerDTOHandler){

        return route(GET("/api/creditcard"), creditCardHandler::findAll)
                .andRoute(GET("/api/creditcard/{id}"), creditCardHandler::findCreditCard)
                .andRoute(POST("/api/creditcard"), creditCardHandler::newCreditCard)
                .andRoute(PUT("/api/creditcard/{id}"), creditCardHandler::updateCreditCard)
                .andRoute(DELETE("/api/creditcard/{id}"), creditCardHandler::deleteCreditCard)
                .andRoute(GET("/api/creditcardcustomer"), creditCardCustomerHandler::findAll)
                .andRoute(GET("/api/creditcardcustomer/{id}"), creditCardCustomerHandler::findCreditCardCustomer)
                .andRoute(POST("/api/creditcardcustomer"), creditCardCustomerHandler::newCreditCardCustomer)
                .andRoute(PUT("/api/creditcardcustomer/{id}"), creditCardCustomerHandler::updateCreditCardCustomer)
                .andRoute(DELETE("/api/creditcardcustomer/{id}"), creditCardCustomerHandler::deleteCreditCardCustomer)
                .andRoute(GET("/api/customerdto"), customerDTOHandler::findAll)
                .andRoute(GET("/api/customerdto/{id}"), customerDTOHandler::findCustomerDTO)
                .andRoute(POST("/api/customerdto"), customerDTOHandler::newCustomerDTO)
                .andRoute(PUT("/api/customerdto/{id}"), customerDTOHandler::updateCustomerDTO)
                .andRoute(DELETE("/api/customerdto/{id}"), customerDTOHandler::deleteCustomerDTO);

    }
}
