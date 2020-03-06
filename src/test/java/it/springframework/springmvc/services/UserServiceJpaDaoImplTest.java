package it.springframework.springmvc.services;

import it.springframework.springmvc.configurations.JpaIntegrationConfiguration;
import it.springframework.springmvc.entities.*;
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
public class UserServiceJpaDaoImplTest {

    private UserService userService;
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

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

    @Test
    public void testAddCartToUser() throws Exception{
        User user = new User();
        user.setUsername("someUsername");
        user.setPassword("myPassword");
        user.setCart(new Cart());
        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }

    @Test
    public void testAddCartToUserWithCartDetails() throws Exception{
        User user = new User();
        user.setUsername("someUsername");
        user.setPassword("myPassword");
        user.setCart(new Cart());
        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
        assert savedUser.getCart().getCartDetails().size() == 2;
    }

    @Test
    public void testAddAndRemoveCartToUserWithCartDetails() throws Exception{
        User user = new User();
        user.setUsername("someUsername");
        user.setPassword("myPassword");
        user.setCart(new Cart());
        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);
        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCardDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);
        assert savedUser.getCart().getCartDetails().size() == 1;
    }


}
