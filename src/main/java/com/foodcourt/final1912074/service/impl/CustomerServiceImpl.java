package com.foodcourt.final1912074.service.impl;

import com.foodcourt.final1912074.data.dao.CustomerDAO;
import com.foodcourt.final1912074.data.dto.CustomerDto;
import com.foodcourt.final1912074.data.dto.CustomerResponseDto;
import com.foodcourt.final1912074.data.entity.Customer;
import com.foodcourt.final1912074.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // 고객번호 보이게
    @Override
    public CustomerResponseDto getCustomer(Long customerNum) {
        Customer customer = customerDAO.selectCustomer(customerNum);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerNum(customer.getCustomerNum());
        customerResponseDto.setCustomerName(customer.getCustomerName());

        return customerResponseDto;
    }
    // 고객번호 안보이게
    @Override
    public List<CustomerDto> getAllCustomer2() {
        List<Customer> lists = customerDAO.getAllCustomer();
        List<CustomerDto> listDto = new ArrayList<>();
        for(Customer c : lists) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustomerName(c.getCustomerName());

            listDto.add(customerDto);
        }
        return listDto;
    }
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> lists = customerDAO.getAllCustomer();
        List<Customer> list = new ArrayList<>();
        for(Customer c : lists) {
            Customer customer = new Customer();
            customer.setCustomerNum(c.getCustomerNum());
            customer.setCustomerName(c.getCustomerName());

            list.add(customer);
        }
        return list;
    }

    @Override
    public CustomerResponseDto saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());

        Customer savedCustomer = customerDAO.insertCustomer(customer);

        CustomerResponseDto customerDto1 = new CustomerResponseDto();
        customerDto1.setCustomerNum(customer.getCustomerNum());
        customerDto1.setCustomerName(savedCustomer.getCustomerName());

        return customerDto1;
    }

    @Override
    public CustomerResponseDto updateCustomerName(Long customerNum, String customerName) throws Exception {
        Customer updateCustomer = customerDAO.updateCustomerName(customerNum, customerName);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerName(updateCustomer.getCustomerName());

        return customerResponseDto;
    }

    @Override
    public void deleteCustomer(Long customerNum) throws Exception {
        customerDAO.deleteCustomer(customerNum);
    }
}
