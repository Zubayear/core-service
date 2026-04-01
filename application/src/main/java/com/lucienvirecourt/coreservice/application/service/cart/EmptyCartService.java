package com.lucienvirecourt.coreservice.application.service.cart;

import com.lucienvirecourt.coreservice.application.port.in.cart.EmptyCartUseCase;
import com.lucienvirecourt.coreservice.application.port.out.persistence.CartRepository;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import java.util.Objects;

/**
 * Use case implementation: Emptying a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
public class EmptyCartService implements EmptyCartUseCase {

  private final CartRepository cartRepository;

  public EmptyCartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public void emptyCart(CustomerId customerId) {
    Objects.requireNonNull(customerId, "'customerId' must not be null");

    cartRepository.deleteByCustomerId(customerId);
  }
}
