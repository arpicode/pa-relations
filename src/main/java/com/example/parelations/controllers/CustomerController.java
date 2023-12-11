package com.example.parelations.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parelations.entities.Customer;
import com.example.parelations.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping(value = "customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomersForHomePage() {
        return customerRepository.findAll();
    }

}
