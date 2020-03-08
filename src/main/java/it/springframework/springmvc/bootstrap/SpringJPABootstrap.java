package it.springframework.springmvc.bootstrap;

import it.springframework.springmvc.entities.*;
import it.springframework.springmvc.enums.OrderStatus;
import it.springframework.springmvc.services.ProductService;
import it.springframework.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadUsersAndCustomers();
        loadCarts();
        loadOrderHistory();
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

    public void loadUsersAndCustomers(){

        User user1 = new User();
        user1.setUsername("r.drummond");
        user1.setPassword("password");

        //First customer
        Customer customer1 = new Customer();
        customer1.setFirstName("Rima");
        customer1.setLastName("Drummond");
        customer1.setEmail("rima.drummond@gmail.com");
        customer1.setPhoneNumber("+1-202-555-0103");
        customer1.setBillingAddress(new Address());
        customer1.setShippingAddress(new Address());
        customer1.getBillingAddress().setAddressLine1("Billing Address 1");
        customer1.getBillingAddress().setAddressLine2("Billing Address 2");
        customer1.getBillingAddress().setCity("Roma");
        customer1.getBillingAddress().setState("Italy");
        customer1.getBillingAddress().setZipCode("00056");
        customer1.getShippingAddress().setAddressLine1("Shipping Address 1");
        customer1.getShippingAddress().setAddressLine2("Shipping Address 2");
        customer1.getShippingAddress().setCity("Roma");
        customer1.getShippingAddress().setState("Italy");
        customer1.getShippingAddress().setZipCode("00056");
        user1.setCustomer(customer1);
        userService.saveOrUpdate(user1);

        //Second customer
        User user2 = new User();
        user2.setUsername("t.riggs");
        user2.setPassword("password2");

        Customer customer2 = new Customer();
        customer2.setFirstName("Tarun");
        customer2.setLastName("Riggs");
        customer2.setEmail("tarun.riggs@gmail.com");
        customer2.setPhoneNumber("+1-202-555-0158");
        customer2.setBillingAddress(new Address());
        customer2.setShippingAddress(new Address());
        customer2.getBillingAddress().setAddressLine1("Billing Address 1");
        customer2.getBillingAddress().setAddressLine2("Billing Address 2");
        customer2.getBillingAddress().setCity("London");
        customer2.getBillingAddress().setState("Great Britain");
        customer2.getBillingAddress().setZipCode("WC2N 5DU");
        customer2.getShippingAddress().setAddressLine1("Shipping Address 1");
        customer2.getShippingAddress().setAddressLine2("Shipping Address 2");
        customer2.getShippingAddress().setCity("London");
        customer2.getShippingAddress().setState("Great Britain");
        customer2.getShippingAddress().setZipCode("WC2N 5DU");
        user2.setCustomer(customer2);
        userService.saveOrUpdate(user2);

        // Third customer
        User user3 = new User();
        user3.setUsername("w.francis");
        user3.setPassword("password3");

        Customer customer3 = new Customer();
        customer3.setFirstName("Waqas");
        customer3.setLastName("Francis");
        customer3.setEmail("wagas.francis@gmail.com");
        customer3.setPhoneNumber("+1-202-555-0116");
        customer3.setBillingAddress(new Address());
        customer3.setShippingAddress(new Address());
        customer3.getBillingAddress().setAddressLine1("Billing Address 1");
        customer3.getBillingAddress().setAddressLine2("Billing Address 2");
        customer3.getBillingAddress().setCity("Paris");
        customer3.getBillingAddress().setState("France");
        customer3.getBillingAddress().setZipCode("75000");
        customer3.getShippingAddress().setAddressLine1("Shipping Address 1");
        customer3.getShippingAddress().setAddressLine2("Shipping Address 2");
        customer3.getShippingAddress().setCity("Paris");
        customer3.getShippingAddress().setState("France");
        customer3.getShippingAddress().setZipCode("75000");
        user3.setCustomer(customer3);
        userService.saveOrUpdate(user3);

        //Fourth customer
        User user4 = new User();
        user4.setUsername("a.ireland");
        user4.setPassword("password4");

        Customer customer4 = new Customer();
        customer4.setFirstName("Ariella");
        customer4.setLastName("Ireland");
        customer4.setEmail("ariella.ireland@gmail.com");
        customer4.setPhoneNumber("+1-202-555-0182");
        customer4.setBillingAddress(new Address());
        customer4.setShippingAddress(new Address());
        customer4.getBillingAddress().setAddressLine1("Billing Address 1");
        customer4.getBillingAddress().setAddressLine2("Billing Address 2");
        customer4.getBillingAddress().setCity("Sydney");
        customer4.getBillingAddress().setState("Australia");
        customer4.getBillingAddress().setZipCode("2000");
        customer4.getShippingAddress().setAddressLine1("Shipping Address 1");
        customer4.getShippingAddress().setAddressLine2("Shipping Address 2");
        customer4.getShippingAddress().setCity("Sydney");
        customer4.getShippingAddress().setZipCode("2000");
        customer4.getShippingAddress().setState("Australia");
        user4.setCustomer(customer4);
        userService.saveOrUpdate(user4);

        //Fifth customer
        User user5 = new User();
        user5.setUsername("p.blair");
        user5.setPassword("password5");

        Customer customer5 = new Customer();
        customer5.setFirstName("Parker");
        customer5.setLastName("Blair");
        customer5.setEmail("parker.blair@gmail.com");
        customer5.setPhoneNumber("+1-202-555-0129");
        customer5.setBillingAddress(new Address());
        customer5.setShippingAddress(new Address());
        customer5.getBillingAddress().setAddressLine1("Billing Address 1");
        customer5.getBillingAddress().setAddressLine2("Billing Address 2");
        customer5.getBillingAddress().setCity("Berlin");
        customer5.getBillingAddress().setState("Germany");
        customer5.getBillingAddress().setZipCode("10115");
        customer5.getShippingAddress().setAddressLine1("Shipping Address 1");
        customer5.getShippingAddress().setAddressLine2("Shipping Address 2");
        customer5.getShippingAddress().setCity("Berlin");
        customer5.getShippingAddress().setState("Germany");
        customer5.getShippingAddress().setZipCode("10115");
        user5.setCustomer(customer5);
        userService.saveOrUpdate(user5);
    }

    public void loadCarts(){
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            user.setCart(new Cart());
            CartDetail cartDetail = new CartDetail();
            cartDetail.setProduct(products.get(0));
            cartDetail.setQuantity(2);
            user.getCart().addCartDetail(cartDetail);
            userService.saveOrUpdate(user);
        });

    }

    public void loadOrderHistory(){
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user ->{
            Order order = new Order();
            order.setCustomer(user.getCustomer());
            order.setOrderStatus(OrderStatus.SHIPPED);

            products.forEach(product -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(1);
                order.addToOrderDetails(orderDetail);
            });
        });
    }
}
