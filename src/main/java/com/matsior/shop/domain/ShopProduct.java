package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "shop_products")
@NoArgsConstructor
public class ShopProduct extends GeneratedId {

  @ManyToOne
  @JoinColumn(name = "shop_id")
  private Shop shop;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private Integer quantity;

  public ShopProduct(final Integer id, final Shop shop, final Product product, final Integer quantity) {
    super(id);
    this.shop = shop;
    this.product = product;
    this.quantity = quantity;
  }
}
