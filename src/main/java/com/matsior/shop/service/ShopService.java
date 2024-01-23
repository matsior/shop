package com.matsior.shop.service;

import com.matsior.shop.domain.Order;
import com.matsior.shop.domain.Shop;
import com.matsior.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class ShopService {

  private final ShopRepository shopRepository;

  @Transactional(readOnly = true)
  public void displayShopStatus(final Integer shopId) {
    final Shop shop = shopRepository.findById(shopId).orElseThrow();
    System.out.println("\n===== Status of shop: " + shop.getCode() + " in " + shop.getCity() + " =====");

    System.out.println("\nShop employees:");
    shop.getUsers()
        .forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

    System.out.println("\nProducts in shop:");
    shop.getShopProducts()
        .forEach(shopProduct -> System.out.println(shopProduct.getProduct().getName() + ": " + shopProduct.getQuantity()));

    System.out.println("\nOrders for shop:");
    for (final Order order : shop.getOrders()) {
      System.out.println(order.getDatetime().truncatedTo(ChronoUnit.MINUTES) + ", ordered by: " + order.getUser().getEmail());
      order.getOrderProducts()
          .forEach(orderProduct -> System.out.println("\t" + orderProduct.getProduct().getName() + ": " + orderProduct.getQuantity()));
    }
  }

}
