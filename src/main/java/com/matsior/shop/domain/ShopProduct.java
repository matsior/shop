package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shop_products")
@NoArgsConstructor
public class ShopProduct extends GeneratedId {

  @ManyToOne
  @JoinColumn(name = "shop_id")
  private Shop shop;

  @ManyToOne
  @JoinColumn(name = "product_details_id")
  private Product product;

  private Integer quantity;

  public ShopProduct(final Integer id, final Shop shop, final Product product, final Integer quantity) {
    super(id);
    this.shop = shop;
    this.product = product;
    this.quantity = quantity;
  }

  public ShopProduct(final Shop shop, final Product product, final Integer quantity) {
    this.shop = shop;
    this.product = product;
    this.quantity = quantity;
  }
}
