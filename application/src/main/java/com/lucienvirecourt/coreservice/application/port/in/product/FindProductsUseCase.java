package com.lucienvirecourt.coreservice.application.port.in.product;

import com.lucienvirecourt.coreservice.model.product.Product;
import java.util.List;

/**
 * Use case: Finding products via a search query.
 *
 * @author Syed Ibna Zubaeyar
 */
public interface FindProductsUseCase {

  List<Product> findByNameOrDescription(String query);
}
