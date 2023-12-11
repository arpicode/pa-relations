package com.example.parelations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parelations.entities.BillingEntity;

public interface BillingEntityRepository extends JpaRepository<BillingEntity, Integer> {

}
