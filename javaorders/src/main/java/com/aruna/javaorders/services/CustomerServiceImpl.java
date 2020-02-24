package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Agent;
import com.aruna.javaorders.models.Customer;
import com.aruna.javaorders.models.Order;
import com.aruna.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findAll() {

        List<Customer> rtnCust = new ArrayList<>();

        custrepos.findAll()
                .iterator()
                .forEachRemaining(rtnCust::add);

        return rtnCust;
    }

    @Override
    public Customer findById(long id) {
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer id: " + id + " Not found"));
    }

    @Override
    public List<Customer> findAllByCustname(String name) {

        List<Customer> rtnCustList = new ArrayList<>(custrepos.findByCustnameContainingIgnoreCase(name));

        if(rtnCustList.size()==0){
            throw new EntityNotFoundException("Customer name with characters "+ name + " not found");
        }
        return rtnCustList;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer newcustomer = new Customer();

        newcustomer.setCustname(customer.getCustname());
        newcustomer.setCustcity(customer.getCustcity());
        newcustomer.setWorkingarea(customer.getWorkingarea());
        newcustomer.setCustcountry(customer.getCustcountry());
        newcustomer.setGrade(customer.getGrade());
        newcustomer.setOpeningamt(customer.getOpeningamt());
        newcustomer.setReceiveamt(customer.getReceiveamt());
        newcustomer.setPaymentamt(customer.getPaymentamt());
        newcustomer.setOutstandingamt(customer.getOutstandingamt());
        newcustomer.setPhone(customer.getPhone());
        newcustomer.setAgent(customer.getAgent());

        for(Order o: customer.getOrders()){
            newcustomer.getOrders().add(new Order(o.getOrdamount(),
                                                  o.getAdvanceamount(),
                                                  newcustomer,
                                                  o.getOrderdescription()));
        }

        return custrepos.save(newcustomer);
    }
}
