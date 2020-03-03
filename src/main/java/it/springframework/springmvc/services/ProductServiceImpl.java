package it.springframework.springmvc.services;

import it.springframework.springmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public ArrayList listAllProducts() {
        return new ArrayList<>(products.values());
    }

    private void loadProducts() {
        products = new HashMap<>();

        //First product
        Product firstProduct = new Product();
        firstProduct.setId(1);
        firstProduct.setDescription("Product 1");
        firstProduct.setPrice(new BigDecimal("12.99"));
        firstProduct.setImageUrl("http://example.com/product1");
        products.put(1, firstProduct);

        //Second product
        Product secondProduct = new Product();
        secondProduct.setId(2);
        secondProduct.setDescription("Product 2");
        secondProduct.setPrice(new BigDecimal("13.99"));
        secondProduct.setImageUrl("http://example.com/product2");
        products.put(2, secondProduct);

        //Third product
        Product thirdProduct = new Product();
        thirdProduct.setId(3);
        thirdProduct.setDescription("Product 3");
        thirdProduct.setPrice(new BigDecimal("14.99"));
        thirdProduct.setImageUrl("http://example.com/product3");
        products.put(3, thirdProduct);

        //Fourth product
        Product fourthProduct = new Product();
        fourthProduct.setId(1);
        fourthProduct.setDescription("Product 4");
        fourthProduct.setPrice(new BigDecimal("15.99"));
        fourthProduct.setImageUrl("http://example.com/product4");
        products.put(4, fourthProduct);
    }
}
