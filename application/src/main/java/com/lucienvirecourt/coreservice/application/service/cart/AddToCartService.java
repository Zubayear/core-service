package com.lucienvirecourt.coreservice.application.service.cart;

import com.lucienvirecourt.coreservice.application.port.in.cart.AddToCartUseCase;
import com.lucienvirecourt.coreservice.application.port.in.cart.ProductNotFoundException;
import com.lucienvirecourt.coreservice.application.port.out.persistence.CartRepository;
import com.lucienvirecourt.coreservice.application.port.out.persistence.ProductRepository;
import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.cart.NotEnoughItemsInStockException;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import com.lucienvirecourt.coreservice.model.product.Product;
import com.lucienvirecourt.coreservice.model.product.ProductId;
import java.util.Objects;

/**
 * Use case implementation: Adding a product to a shopping cart.
 *
 * @author Syed Ibna Zubaeyar
 */
public class AddToCartService implements AddToCartUseCase {

  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  public AddToCartService(
      CartRepository cartRepository, ProductRepository productRepositoryVeryVeryLong) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepositoryVeryVeryLong;
  }

  @Override
  public Cart addToCart(CustomerId customerIdVeryVeryLong, ProductId productId, int quantity)
      throws ProductNotFoundException, NotEnoughItemsInStockException {
    Objects.requireNonNull(customerIdVeryVeryLong, "'customerId' must not be null");
    Objects.requireNonNull(productId, "'productId' must not be null");
    if (quantity < 1) {
      throw new IllegalArgumentException("'quantity' must be greater than 0");
    }

    Product product =
        productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

    Cart cart =
        cartRepository
            .findByCustomerId(customerIdVeryVeryLong)
            .orElseGet(() -> new Cart(customerIdVeryVeryLong));

    cart.addProduct(product, quantity);

    cartRepository.save(cart);

    return cart;
  }
}
