package com.example.parelations.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.parelations.entities.BillingEntity;
import com.example.parelations.entities.Customer;
import com.example.parelations.entities.Service;
import com.example.parelations.repositories.BillingEntityRepository;
import com.example.parelations.repositories.CustomerRepository;
import com.example.parelations.repositories.ServiceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final CustomerRepository customerRepository;
    private final BillingEntityRepository billingEntityRepository;
    private final ServiceRepository serviceRepository;

    @Bean
    @Transactional
    CommandLineRunner loadData() {
        return args -> {
            createAlphabetCustomer();
            createAppleCustomer();
        };
    }

    private void createAlphabetCustomer() {
        Customer customer = Customer.builder()
                .commercialName("Alphabet Inc.")
                .build();

        BillingEntity billingEntity1 = BillingEntity.builder()
                .name("Google Cloud Platform")
                .customer(customer)
                .build();

        BillingEntity billingEntity2 = BillingEntity.builder()
                .name("Google Workspace")
                .customer(customer)
                .build();

        customer.setBillingEntities(List.of(billingEntity1, billingEntity2));

        Service service1 = Service.builder()
                .name("Compute Engine")
                .billingEntity(billingEntity1)
                .customer(customer)
                .build();

        Service service2 = Service.builder()
                .name("Cloud Storage")
                .billingEntity(billingEntity1)
                .customer(customer)
                .build();

        Service service3 = Service.builder()
                .name("Gmail")
                .billingEntity(billingEntity2)
                .customer(customer)
                .build();

        Service service4 = Service.builder()
                .name("Google Drive")
                .billingEntity(billingEntity2)
                .customer(customer)
                .build();

        billingEntity1.setServices(List.of(service1, service2));
        billingEntity2.setServices(List.of(service3, service4));

        customerRepository.save(customer);
        billingEntityRepository.saveAll(List.of(billingEntity1, billingEntity2));
        serviceRepository.saveAll(List.of(service1, service2, service3, service4));
    }

    private void createAppleCustomer() {
        Customer customer = Customer.builder()
                .commercialName("Apple Inc.")
                .build();

        BillingEntity billingEntity1 = BillingEntity.builder()
                .name("Apple Cloud")
                .customer(customer)
                .build();

        BillingEntity billingEntity2 = BillingEntity.builder()
                .name("Apple Music")
                .customer(customer)
                .build();

        customer.setBillingEntities(List.of(billingEntity1, billingEntity2));

        Service service1 = Service.builder()
                .name("iCloud")
                .billingEntity(billingEntity1)
                .customer(customer)
                .build();

        Service service2 = Service.builder()
                .name("Apple Arcade")
                .billingEntity(billingEntity1)
                .customer(customer)
                .build();

        Service service3 = Service.builder()
                .name("Apple Music")
                .billingEntity(billingEntity2)
                .customer(customer)
                .build();

        billingEntity1.setServices(List.of(service1, service2));
        billingEntity2.setServices(List.of(service3));

        customerRepository.save(customer);
        billingEntityRepository.saveAll(List.of(billingEntity1, billingEntity2));
        serviceRepository.saveAll(List.of(service1, service2, service3));
    }

}
