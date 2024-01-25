package com.matsior.shop;

import com.matsior.shop.service.ShopProductsService;
import com.matsior.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
class Test implements CommandLineRunner {

  private final ShopService shopService;
  private final ShopProductsService shopProductsService;

  @Override
  public void run(final String... args) throws Exception {
    shopProductsService.addProductsToShop(1, Map.of(1, 123, 2, 345, 3, 20));
//    shopService.displayShopStatus(1);
    shopProductsService.getProductsInShop(1)
        .forEach(System.out::println);
  }

}
