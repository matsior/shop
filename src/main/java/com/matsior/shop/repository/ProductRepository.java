package com.matsior.shop.repository;

import com.matsior.shop.domain.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {

}
