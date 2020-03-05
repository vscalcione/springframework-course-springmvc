package it.springframework.springmvc.services;

import it.springframework.springmvc.configurations.JpaIntegrationConfiguration;
import it.springframework.springmvc.domain.Customer;
import it.springframework.springmvc.services.customer.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfiguration.class)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testList() throws Exception{
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assert customers.size() == 5;
    }
}
