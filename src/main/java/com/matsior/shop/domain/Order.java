package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order extends GeneratedId {

  private LocalDateTime datetime;

  private String status;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "shop_id")
  private Shop shop;

  @OneToMany(mappedBy = "order")
  private Set<OrderProduct> orderProducts;

  public Order(final Integer id, final LocalDateTime datetime, final String status, final User user, final Shop shop, final Set<OrderProduct> orderProducts) {
    super(id);
    this.datetime = datetime;
    this.status = status;
    this.user = user;
    this.shop = shop;
    this.orderProducts = orderProducts;
  }
}
