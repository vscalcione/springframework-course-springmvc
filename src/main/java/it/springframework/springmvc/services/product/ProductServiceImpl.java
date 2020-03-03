package it.springframework.springmvc.services.product;

import it.springframework.springmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    /**
     * Metodo che ritorna una lista contenente tutti i prodotti
     * @return
     */
    @Override
    public ArrayList listAllProducts() {
        return new ArrayList<>(products.values());
    }

    /**
     * Metodo che ritorna l'id di ogni singolo prodotto
     * @param id
     * @return
     */
    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    /**
     * Metodo che permette di salvare o aggiornare ogni singolo prodotto
     * @param product
     * @return
     */
    @Override
    public Product saveOrUpdateProduct(Product product) {
        if(product != null){
            if(product.getId() == null){
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);
            return product;
        }else{
            throw new RuntimeException("Product can't be null!!!");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) + 1;
    }

    /**
     * Metodo che permette di caricare tutti i prodotti
     */
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
