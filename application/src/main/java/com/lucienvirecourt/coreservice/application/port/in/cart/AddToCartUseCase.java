package com.lucienvirecourt.coreservice.application.port.in.cart;

import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.cart.NotEnoughItemsInStockException;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import com.lucienvirecourt.coreservice.model.product.ProductId;

/**
 * Use case: Adding a product to a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
public interface AddToCartUseCase {

  Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
      throws ProductNotFoundException, NotEnoughItemsInStockException;
}
