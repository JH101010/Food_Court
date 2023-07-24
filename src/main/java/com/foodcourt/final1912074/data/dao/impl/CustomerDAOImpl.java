package com.foodcourt.final1912074.data.dao.impl;

import com.foodcourt.final1912074.data.dao.CustomerDAO;
import com.foodcourt.final1912074.data.entity.Customer;
import com.foodcourt.final1912074.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDAOImpl implements CustomerDAO {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerDAOImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    // 삽입
    @Override
    public Customer insertCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    // 특정 조회
    @Override
    public Customer selectCustomer(Long customerNum) {
        Customer selectedCustomer = customerRepository.getById(customerNum);

        return selectedCustomer;
    }

    // 전체 조회
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> lists = customerRepository.findAll();
        return lists;
    }

    //
    @Override
    public Customer updateCustomerName(Long customerNum, String customerName) throws Exception {
        Optional<Customer> selectedCustomer = customerRepository.findById(customerNum);

        Customer updatedCustomer;
        if(selectedCustomer.isPresent()) {
            Customer customer = selectedCustomer.get();

            customer.setCustomerName(customerName);

            updatedCustomer = customerRepository.save(customer);
        } else {
            throw new Exception();
        }
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(Long customerNum) throws Exception {
        Optional<Customer> selectedCustomer = customerRepository.findById(customerNum);

        if(selectedCustomer.isPresent()) {
            Customer customer = selectedCustomer.get();

            customerRepository.delete(customer);
        } else {
            throw new Exception();
        }
    }
}
