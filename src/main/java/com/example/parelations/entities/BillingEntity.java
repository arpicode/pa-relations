package com.example.parelations.entities;

import java.util.List;

import com.example.parelations.views.Views;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ Views.Customer.DetailsPage.class })
    private Integer id;

    @JsonView({ Views.Customer.DetailsPage.class })
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id") // optional
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "billingEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Service> services;

}