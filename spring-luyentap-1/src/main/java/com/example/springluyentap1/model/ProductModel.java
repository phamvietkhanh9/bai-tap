package com.example.springluyentap1.model;

import com.example.springluyentap1.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductModel extends PagingAndSortingRepository<Product, Integer> {

    Page<Product> findProductsByPrice(int price, Pageable pageable);

    Page<Product> findProductsByStatus(int status, Pageable pageable);

    Page<Product> findByName(String name, Pageable pageable);

    @Query(value = "SELECT product FROM Product product WHERE product.name LIKE :name% AND product.status = :status")
    Page<Product> findByNameAndStatus(String name, int status, Pageable pageable);

    Page<Product> findProductByStatus(int status, Pageable pageable);
}
