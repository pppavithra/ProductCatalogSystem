package com.guvi.ProductCatalogSystem.controller;

import com.guvi.ProductCatalogSystem.entity.Product;
import com.guvi.ProductCatalogSystem.repository.ProductRepository;
import com.guvi.ProductCatalogSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {


    //inject service layer into ProductController
    @Autowired
    private ProductService productService;


    //handler method for GET request ->/
    @GetMapping("/")
    public String index() {
        //return index.html
        return "index";
    }

    //controller to /addProduct->display form
    @GetMapping("/addProduct")
    public String showAddProductForm() {
        return "addProduct";
    }

    //Controller endpoint /addProduct->save product->post
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        //called saveproduct
        productService.saveProduct(product);
        return "redirect:/";//redirect to index after form submit
    }

    //controller endpoints to displayProduct
    @GetMapping("/displayProduct")
    public String showDisplayProductForm(Model model) {
        //add a new product object to model
        model.addAttribute("product", new Product());
        //return
        return "displayProduct";
    }

    //post method to get the data by category
    @PostMapping("/displayProduct")
    public String displayProduct(@RequestParam("category") String category, Model model) {
        //call service to get all product by category
        List<Product> products = productService.getAllProductsByCategory(category);
        //add the product list to model with
        model.addAttribute("products", products);
        return "productList";

    }


        //create getmethod->to display all product
//    findall()/->product.html
        @GetMapping("/products)")
        public String listProduct(Model model)
    {
        System.out.println("get all products...");

    model.addAttribute("products", productService.getAllProducts());
     return "products";

    }
}





