package com.lucienvirecourt.coreservice.application.port.out.persistence;

import com.lucienvirecourt.coreservice.model.product.Product;
import com.lucienvirecourt.coreservice.model.product.ProductId;

import java.util.List;
import java.util.Optional;

/**
 * Outgoing persistence port for products.
 *
 * @author Syed Ibna Zubaeyar
 */
public interface ProductRepository {

  void save(Product product);

  Optional<Product> findById(ProductId productId);

  List<Product> findByNameOrDescription(String query);
}
