package com.example.parelations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parelations.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
