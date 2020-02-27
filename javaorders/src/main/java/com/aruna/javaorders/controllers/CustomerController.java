package com.aruna.javaorders.controllers;

import com.aruna.javaorders.models.Customer;
import com.aruna.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //GET http://localhost:2023/customers/orders
    @GetMapping(value="/orders",
                produces = {"application/json"})
    public ResponseEntity<?> listAllOrders(){
        List<Customer> rtnList = customerService.findAll();

        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }


    //GET http://localhost:2023/customers/customer/7
    @GetMapping(value = "/customer/{custcode}",
                produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable long custcode)
    {
        Customer myCust = customerService.findById(custcode);
        return new ResponseEntity<>(myCust,HttpStatus.OK);
    }


    //GET http://localhost:2023/customers/namelike/mes
    @GetMapping(value = "/namelike/{matchletters}",
                 produces = {"application/json"})
    public ResponseEntity<?> findByNames(@PathVariable String matchletters){
        List<Customer> rtnCustNames = customerService.findAllByCustname(matchletters);

        return new ResponseEntity<>(rtnCustNames, HttpStatus.OK);
    }



}