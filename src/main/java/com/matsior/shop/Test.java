package com.matsior.shop;

import com.matsior.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class Test implements CommandLineRunner {

  private final ShopService shopService;

  @Override
  public void run(final String... args) throws Exception {
    shopService.displayShopStatus(1);
  }

}
