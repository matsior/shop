package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User extends GeneratedId {

  private String firstName;

  private String lastName;

  private String email;

  @ManyToOne
  @JoinColumn(name = "shop_id")
  private Shop shop;

  @OneToMany(mappedBy = "user")
  private Set<Order> orders;

  public User(final Integer id, final String firstName, final String lastName, final String email, final Shop shop,
      final Set<Order> orders) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.shop = shop;
    this.orders = orders;
  }
}
