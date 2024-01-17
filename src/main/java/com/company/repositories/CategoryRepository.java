package com.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
   
  	
}
