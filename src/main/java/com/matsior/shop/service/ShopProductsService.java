package com.matsior.shop.service;

import com.matsior.shop.domain.Product;
import com.matsior.shop.domain.Shop;
import com.matsior.shop.domain.ShopProduct;
import com.matsior.shop.dto.ProductInShop;
import com.matsior.shop.repository.ProductRepository;
import com.matsior.shop.repository.ShopProductRepository;
import com.matsior.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ShopProductsService {

  private final ShopProductRepository shopProductRepository;
  private final ProductRepository productRepository;
  private final ShopRepository shopRepository;

  @Transactional(readOnly = true)
  public List<ProductInShop> getProductsInShop(Integer shopId) {
    return shopProductRepository.findAllByShopId(shopId).stream()
        .map(entity -> ProductInShop.builder()
            .productName(entity.getProduct().getName())
            .quantity(entity.getQuantity())
            .build())
        .toList();
  }

  @Transactional
  public void addProductsToShop(Integer shopId, Map<Integer, Integer> products) {
    products.forEach((productId, productQuantity) -> addProductToShop(shopId, productId, productQuantity));
  }

  @Transactional
  public void addProductToShop(Integer shopId, Integer productId, Integer quantity) {
    final Shop shop = shopRepository.findById(shopId)
        .orElseThrow();

    final Product product = productRepository.findById(productId)
        .orElseThrow();

    final ShopProduct shopProduct = shopProductRepository.findProductByShopIdAndProductId(shopId, productId)
        .orElseGet(() -> new ShopProduct(shop, product, 0));

    shopProduct.setQuantity(shopProduct.getQuantity() + quantity);

    shopProductRepository.save(shopProduct);
  }

}
