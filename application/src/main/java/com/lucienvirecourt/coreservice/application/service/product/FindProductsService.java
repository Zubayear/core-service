package com.lucienvirecourt.coreservice.application.service.product;

import com.lucienvirecourt.coreservice.application.port.in.product.FindProductsUseCase;
import com.lucienvirecourt.coreservice.application.port.out.persistence.ProductRepository;
import com.lucienvirecourt.coreservice.model.product.Product;
import java.util.List;
import java.util.Objects;

/**
 * Use case implementation: Finding products via a search query.
 *
 * @author Syed Ibna Zubaeyar
 */
public class FindProductsService implements FindProductsUseCase {

  private final ProductRepository productRepository;

  public FindProductsService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> findByNameOrDescription(String query) {
    Objects.requireNonNull(query, "'query' must not be null");
    if (query.length() < 2) {
      throw new IllegalArgumentException("'query' must be at least two characters long");
    }

    return productRepository.findByNameOrDescription(query);
  }
}
