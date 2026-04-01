package com.lucienvirecourt.coreservice.application.service.cart;

import com.lucienvirecourt.coreservice.application.port.in.cart.GetCartUseCase;
import com.lucienvirecourt.coreservice.application.port.out.persistence.CartRepository;
import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import java.util.Objects;

/**
 * Use case implementation: Retrieving a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
public class GetCartService implements GetCartUseCase {

  private final CartRepository cartRepository;

  public GetCartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public Cart getCart(CustomerId customerIdVeryLong) {
    Objects.requireNonNull(customerIdVeryLong, "'customerId' must not be null");

    return cartRepository
        .findByCustomerId(customerIdVeryLong)
        .orElseGet(() -> new Cart(customerIdVeryLong));
  }
}
