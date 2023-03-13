package com.lewis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lewis.entities.ProductCategory;
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
