package com.example.parelations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parelations.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
