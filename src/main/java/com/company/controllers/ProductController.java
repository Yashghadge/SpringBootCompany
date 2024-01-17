package com.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.models.Product;
import com.company.services.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    
    @GetMapping("/categories/{id}/products")
    public ResponseEntity<?> GetAllCategoryByProductId(@PathVariable int id){
    	return productService.GetAllCategoryByProductId(id);
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<?> GetCategoryByProductId(@PathVariable int id){
		return productService.GetCategoryByProductId(id);
	}
    
    @PostMapping("/categories/{id}/products")
    public ResponseEntity<?> CresteProduct(@PathVariable int id,@RequestBody Product productRequest)
    {
    	return productService.CresteProduct(id, productRequest);
    }
}
