package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Entity
@Table(name = "shops")
@NoArgsConstructor
public class Shop extends GeneratedId {

  private String code;

  private String city;

  @OneToMany(mappedBy = "shop")
  private Set<User> users;

  @OneToMany(mappedBy = "shop")
  private Set<Order> orders;

  @OneToMany(mappedBy = "shop")
  private Set<ShopProduct> shopProducts;

  public Shop(final Integer id, final String code, final String city, final Set<User> users, final Set<Order> orders,
      final Set<ShopProduct> shopProducts) {
    super(id);
    this.code = code;
    this.city = city;
    this.users = users;
    this.orders = orders;
    this.shopProducts = shopProducts;
  }
}
