package com.example.parelations.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.parelations.entities.Service;
import com.example.parelations.repositories.ServiceRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ServiceController {

    private final ServiceRepository serviceRepository;

    @GetMapping(value = "/services", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Service> getServicesWithCustomerAndBillingEntity() {
        return serviceRepository.findAll();
    }

}
