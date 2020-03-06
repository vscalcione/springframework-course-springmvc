package it.springframework.springmvc.services;

import it.springframework.springmvc.configurations.JpaIntegrationConfiguration;
import it.springframework.springmvc.entities.Customer;
import it.springframework.springmvc.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfiguration.class)
@ActiveProfiles("jpadao")
public class UserServiceJpaDaoImplTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testSaveUser() throws Exception{
        User user = new User();
        user.setUsername("someusername");
        user.setPassword("myPassword");
        User savedUser = userService.saveOrUpdate(user);
        assert savedUser.getId() != null;
        assert savedUser.getEncryptedPassword() != null;
        System.out.println("Encrypted Password");
        System.out.println(savedUser.getEncryptedPassword());
    }

    @Test
    public void testSaveUserWithCustomer() throws Exception{
        User user = new User();
        user.setUsername("someusername");
        user.setPassword("mypassword");

        Customer customer = new Customer();
        customer.setFirstName("Chevy");
        customer.setLastName("Chase");
        user.setCustomer(customer);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }
}