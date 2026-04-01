package com.lucienvirecourt.coreservice.adapter.out.persistence.inmemory;

import com.lucienvirecourt.coreservice.application.port.out.persistence.CartRepository;
import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

/**
 * Persistence adapter: Stores carts in memory.
 *
 * @author Syed Ibna Zubaeyar
 */
@ConditionalOnProperty(name = "persistence", havingValue = "inmemory", matchIfMissing = true)
@Repository
public class InMemoryCartRepository implements CartRepository {

  private final Map<CustomerId, Cart> carts = new ConcurrentHashMap<>();

  @Override
  public void save(Cart cart) {
    carts.put(cart.id(), cart);
  }

  @Override
  public Optional<Cart> findByCustomerId(CustomerId customerId) {
    return Optional.ofNullable(carts.get(customerId));
  }

  @Override
  public void deleteByCustomerId(CustomerId customerId) {
    carts.remove(customerId);
  }
}
