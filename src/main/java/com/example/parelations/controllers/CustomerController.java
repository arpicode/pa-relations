package com.example.parelations.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parelations.entities.Customer;
import com.example.parelations.repositories.CustomerRepository;
import com.example.parelations.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Customer.HomePage.class)
    public List<Customer> getCustomersForHomePage() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerDetails(@PathVariable Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

}
