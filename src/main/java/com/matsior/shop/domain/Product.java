package com.matsior.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product extends GeneratedId {

  private String name;

  private BigDecimal price;

  public Product(final Integer id, final String name, final BigDecimal price) {
    super(id);
    this.name = name;
    this.price = price;
  }
}
