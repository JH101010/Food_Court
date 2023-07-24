package com.foodcourt.final1912074.controller;

import com.foodcourt.final1912074.data.dto.CustomerDto;
import com.foodcourt.final1912074.data.dto.CustomerResponseDto;
import com.foodcourt.final1912074.data.entity.Customer;
import com.foodcourt.final1912074.data.entity.QCustomer;
import com.foodcourt.final1912074.service.CustomerService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PersistenceContext
    EntityManager entityManager;


    // 고객번호 보이게
    /*@GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> lists = customerService.getAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }*/
    @GetMapping("/getAll")
    public String getAllCustomer(Model model) {
        List<Customer> lists = customerService.getAllCustomer();
        model.addAttribute("customerList", lists);
        return "wait";
    }

    // 고객번호 안보이게
    @GetMapping("/getAll2")
    public ResponseEntity<List<CustomerDto>> getAllCustomer2() {
        List<CustomerDto> lists = customerService.getAllCustomer2();
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }

    // 이름으로 조회
    @GetMapping("/getName") // ..../getName?name=하하
    public ResponseEntity<List<Customer>> getName(String name) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QCustomer qCustomer = QCustomer.customer;

        List<Customer> customerList = jpaQueryFactory
                .select(qCustomer)
                .from(qCustomer)
                .where(qCustomer.customerName.eq(name))
                .fetch();
        for(Customer customer : customerList) {
            System.out.println("====================");
            System.out.println("고객번호: " + customer.getCustomerNum());
            System.out.println("고객이름: " + customer.getCustomerName());
            System.out.println("====================");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerList);
    }


//     데이터 입력방법
//    {
//        "customerName" : "aaa"
//    }

    // insert
    /*@PostMapping() // "customerName":"___" 변수 이름과 같게 했어야했음, 테이블 이름을 따라가는 것이 아님.
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerResponseDto customerResponseDto = customerService.saveCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }*/
    @PostMapping("/save") // "customerName":"___" 변수 이름과 같게 했어야했음, 테이블 이름을 따라가는 것이 아님.
    public String createCustomer(CustomerDto customerDto, HttpServletRequest request) {
        HttpSession session1 = request.getSession();
        session1.setAttribute("state", "YES");
        session1.setAttribute("name", customerDto.getCustomerName());
        CustomerResponseDto customerDto1 = customerService.saveCustomer(customerDto);
        session1.setAttribute("cId", customerDto1.getCustomerNum());
        return "index";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("state", "No");
        session.setAttribute("cId","");
        return "index";
    }

    // 삭제
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) throws Exception {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + "번 정상 삭제완료..");
    }*/
    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Long customerId) throws Exception {
        customerService.deleteCustomer(customerId);
        return "index";
    }

    // 수정
    @PutMapping()
    public ResponseEntity<CustomerResponseDto> updateCustomerName(@RequestBody CustomerResponseDto customerResponseDto) throws Exception {
        CustomerResponseDto responseDto = customerService.updateCustomerName(
                customerResponseDto.getCustomerNum(), customerResponseDto.getCustomerName());
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
