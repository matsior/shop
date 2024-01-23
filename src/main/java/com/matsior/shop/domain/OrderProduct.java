package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order_products")
@NoArgsConstructor
public class OrderProduct extends GeneratedId {

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private Integer quantity;

  public OrderProduct(final Integer id, final Order order, final Product product) {
    super(id);
    this.order = order;
    this.product = product;
  }
}
