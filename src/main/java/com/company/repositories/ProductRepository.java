package com.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.company.models.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{
   
  List<Product> findByCategoryId(int id);
}
