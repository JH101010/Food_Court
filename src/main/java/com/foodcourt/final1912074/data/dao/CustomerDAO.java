package com.foodcourt.final1912074.data.dao;

import com.foodcourt.final1912074.data.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer insertCustomer(Customer customer);

    Customer selectCustomer(Long customerNum);

    List<Customer> getAllCustomer();

    Customer updateCustomerName(Long customerNum, String customerName) throws Exception;
    void deleteCustomer(Long customerNum) throws Exception;
}
