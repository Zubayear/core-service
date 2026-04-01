package com.lucienvirecourt.coreservice.application.port.in.cart;

import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;

/**
 * Use case: Retrieving a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
public interface GetCartUseCase {

  Cart getCart(CustomerId customerId);
}
