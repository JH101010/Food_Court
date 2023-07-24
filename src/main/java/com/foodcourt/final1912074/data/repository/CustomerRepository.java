package com.foodcourt.final1912074.data.repository;

import com.foodcourt.final1912074.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
