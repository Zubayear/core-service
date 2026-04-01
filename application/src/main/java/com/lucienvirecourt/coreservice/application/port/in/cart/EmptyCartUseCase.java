package com.lucienvirecourt.coreservice.application.port.in.cart;

import com.lucienvirecourt.coreservice.model.customer.CustomerId;

/**
 * Use case: Emptying a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
public interface EmptyCartUseCase {

  void emptyCart(CustomerId customerId);
}
