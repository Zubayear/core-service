package com.lucienvirecourt.coreservice.application.port.out.persistence;

import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import java.util.Optional;

/**
 * Outgoing persistence port for carts.
 *
 * @author Syed Ibna Zubaeyar
 */
public interface CartRepository {

  void save(Cart cart);

  Optional<Cart> findByCustomerId(CustomerId customerId);

  void deleteByCustomerId(CustomerId customerId);
}
