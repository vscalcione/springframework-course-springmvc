package it.springframework.springmvc.services;

import it.springframework.springmvc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();
    Product getProductById(Integer id);

}
