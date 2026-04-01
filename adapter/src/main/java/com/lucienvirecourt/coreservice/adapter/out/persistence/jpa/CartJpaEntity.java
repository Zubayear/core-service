package com.lucienvirecourt.coreservice.adapter.out.persistence.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * JPA entity class for a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
@Entity
@Table(name = "cart")
@Getter
@Setter
public class CartJpaEntity {

  @Id private int customerId;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CartLineItemJpaEntity> lineItems;
}
