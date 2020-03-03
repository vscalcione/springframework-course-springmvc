package it.springframework.springmvc.controllers;

import it.springframework.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    /**
     * Metodo che ritorna la model con la lista di tutti i prodotti
     * @param model
     * @return
     */
    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    /**
     * Metodo che ritorna il model del dettaglio di ogni singolo prodotto
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }
}