package com.matsior.shop.repository;

import com.matsior.shop.domain.Shop;
import com.matsior.shop.domain.ShopProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShopProductRepository extends ListCrudRepository<ShopProduct, Integer> {

  @Query("""
      SELECT sp
      FROM ShopProduct sp
      JOIN FETCH sp.product
      JOIN FETCH sp.shop
      WHERE sp.shop.id = :shopId
      """)
  List<ShopProduct> findAllByShopId(Integer shopId);

  Optional<ShopProduct> findProductByShopIdAndProductId(Integer shopId, Integer productId);
}
