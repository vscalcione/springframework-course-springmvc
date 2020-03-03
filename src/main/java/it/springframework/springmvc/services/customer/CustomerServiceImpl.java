package it.springframework.springmvc.services.customer;

import it.springframework.springmvc.domain.Customer;
import it.springframework.springmvc.services.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCostumers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customer != null){
            if(customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
            return customer;
        }else{
            throw new RuntimeException("Customer can't be null!!!");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers(){
        customers = new HashMap<>();

        //First customer
        Customer firstCustomer = new Customer();
        firstCustomer.setId(1);
        firstCustomer.setFirstName("aaaaaaaa");
        firstCustomer.setLastName("aaaaaaaa");
        firstCustomer.setEmail("aaaaaaaa@aaaaaaaa");
        firstCustomer.setPhoneNumber("123456789");
        firstCustomer.setAddressLine1("aaaaaaaa");
        firstCustomer.setAddressLine2("aaaaaaaa");
        firstCustomer.setCity("Rome");
        firstCustomer.setState("Italy");
        firstCustomer.setZipCode("00012");
        customers.put(1, firstCustomer);

        //Second customer
        Customer secondCustomer = new Customer();
        secondCustomer.setId(1);
        secondCustomer.setFirstName("bbbbbbb");
        secondCustomer.setLastName("bbbbbbb");
        secondCustomer.setEmail("bbbbbbb@bbbbbbb");
        secondCustomer.setPhoneNumber("123456789");
        secondCustomer.setAddressLine1("bbbbbbb");
        secondCustomer.setAddressLine2("bbbbbbb");
        secondCustomer.setCity("Rome");
        secondCustomer.setState("Italy");
        secondCustomer.setZipCode("00034");
        customers.put(2, secondCustomer);

        //Third customer
        Customer thirdCustomer = new Customer();
        thirdCustomer.setId(1);
        thirdCustomer.setFirstName("cccccc");
        thirdCustomer.setLastName("cccccc");
        thirdCustomer.setEmail("cccccc@cccccc");
        thirdCustomer.setPhoneNumber("123456789");
        thirdCustomer.setAddressLine1("cccccc");
        thirdCustomer.setAddressLine2("cccccc");
        thirdCustomer.setCity("Rome");
        thirdCustomer.setState("Italy");
        thirdCustomer.setZipCode("00056");
        customers.put(2, thirdCustomer);

        //Fourth customer
        Customer fourthCustomer = new Customer();
        fourthCustomer.setId(1);
        fourthCustomer.setFirstName("ddddd");
        fourthCustomer.setLastName("ddddd");
        fourthCustomer.setEmail("ddddd@ddddd");
        fourthCustomer.setPhoneNumber("123456789");
        fourthCustomer.setAddressLine1("ddddd");
        fourthCustomer.setAddressLine2("ddddd");
        fourthCustomer.setCity("Rome");
        fourthCustomer.setState("Italy");
        fourthCustomer.setZipCode("00078");
        customers.put(4, fourthCustomer);
    }
}
