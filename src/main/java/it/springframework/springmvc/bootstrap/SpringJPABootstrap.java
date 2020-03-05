package it.springframework.springmvc.bootstrap;

import it.springframework.springmvc.domain.Customer;
import it.springframework.springmvc.domain.Product;
import it.springframework.springmvc.services.customer.CustomerService;
import it.springframework.springmvc.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }

    public void loadProducts(){

        //First product
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        //Second product
        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        //Third product
        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        //Fourth product
        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        //Fifth product
        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }

    public void loadCustomers(){

        //First customer
        Customer customer1 = new Customer();
        customer1.setFirstName("firstName1");
        customer1.setLastName("lastName1");
        customer1.setEmail("email1");
        customer1.setPhoneNumber("phoneNumber1");
        customer1.setAddressLine1("firstAddressLine1");
        customer1.setAddressLine2("secondAddressLine1");
        customer1.setCity("city");
        customer1.setState("state1");
        customer1.setZipCode("zipCode1");
        customerService.saveOrUpdate(customer1);

        //Second customer
        Customer customer2 = new Customer();
        customer2.setFirstName("firstName2");
        customer2.setLastName("lastName2");
        customer2.setEmail("email2");
        customer2.setPhoneNumber("phoneNumber2");
        customer2.setAddressLine1("firstAddressLine2");
        customer2.setAddressLine2("secondAddressLine2");
        customer2.setCity("city2");
        customer2.setState("state2");
        customer2.setZipCode("zipCode2");
        customerService.saveOrUpdate(customer2);

        //Third customer
        Customer customer3 = new Customer();
        customer3.setFirstName("firstName3");
        customer3.setLastName("lastName3");
        customer3.setEmail("email3");
        customer3.setPhoneNumber("phoneNumber3");
        customer3.setAddressLine1("firstAddressLine3");
        customer3.setAddressLine2("secondAddressLine3");
        customer3.setCity("city3");
        customer3.setState("state3");
        customer3.setZipCode("zipCode3");
        customerService.saveOrUpdate(customer3);

        //Fourth customer
        Customer customer4 = new Customer();
        customer4.setFirstName("firstName4");
        customer4.setLastName("lastName4");
        customer4.setEmail("email4");
        customer4.setPhoneNumber("phoneNumber4");
        customer4.setAddressLine1("firstAddressLine4");
        customer4.setAddressLine2("secondAddressLine4");
        customer4.setCity("city4");
        customer4.setState("state4");
        customer4.setZipCode("zipCode4");
        customerService.saveOrUpdate(customer4);

        //Fifth customer
        Customer customer5 = new Customer();
        customer5.setFirstName("firstName5");
        customer5.setLastName("lastName5");
        customer5.setEmail("email5");
        customer5.setPhoneNumber("phoneNumber5");
        customer5.setAddressLine1("firstAddressLine5");
        customer5.setAddressLine2("secondAddressLine5");
        customer5.setCity("city5");
        customer5.setState("state5");
        customer5.setZipCode("zipCode5");
        customerService.saveOrUpdate(customer5);
    }
}