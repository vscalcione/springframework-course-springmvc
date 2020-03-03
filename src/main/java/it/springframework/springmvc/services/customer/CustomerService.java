package it.springframework.springmvc.services.customer;

import it.springframework.springmvc.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCostumers();
    Customer getCustomerById(Integer id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
