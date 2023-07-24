package com.foodcourt.final1912074.service;

import com.foodcourt.final1912074.data.dto.CustomerDto;
import com.foodcourt.final1912074.data.dto.CustomerResponseDto;
import com.foodcourt.final1912074.data.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto getCustomer(Long customerNum);
    // 고객번호 보이게
    List<Customer> getAllCustomer();
    // 고객번호 안보이게
    List<CustomerDto> getAllCustomer2();
    // 저장
    CustomerResponseDto saveCustomer(CustomerDto customerDto);

    CustomerResponseDto updateCustomerName(Long customerNum, String customerName) throws Exception;

    void deleteCustomer(Long customerNum) throws Exception;
}
