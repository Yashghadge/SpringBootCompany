package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.models.Product;
import com.company.repositories.CategoryRepository;
import com.company.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
   
	public ResponseEntity<?> GetAllCategoryByProductId(int id) {
		if (!productRepository.existsById(id)) {
			 throw new ResourceNotFoundException("Not found Tutorial with id = " + id);
		}
		List<Product> products = productRepository.findByCategoryId(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	public ResponseEntity<?> GetCategoryByProductId(int id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

	    return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	public ResponseEntity<?> CresteProduct(int id,Product productRequest) {
		Product products = categoryRepository.findById(id).map(category->
		{
			productRequest.setCategory(category);
			return productRepository.save(productRequest);
		}).orElseThrow(
				() -> new ResourceNotFoundException("Not found Tutorial with id = " + id)
				);
		 return new ResponseEntity<>(products, HttpStatus.CREATED);
	}
}
