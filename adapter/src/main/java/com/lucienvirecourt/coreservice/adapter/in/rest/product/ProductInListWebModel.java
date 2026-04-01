package com.lucienvirecourt.coreservice.adapter.in.rest.product;

import com.lucienvirecourt.coreservice.model.money.Money;
import com.lucienvirecourt.coreservice.model.product.Product;

/**
 * Model class for returning a product (in a list ... that's without description) via REST API.
 *
 * @author Syed Ibna Zubaeyar
 */
public record ProductInListWebModel(String id, String name, Money price, int itemsInStock) {

  public static ProductInListWebModel fromDomainModel(Product product) {
    return new ProductInListWebModel(
        product.id().value(), product.name(), product.price(), product.itemsInStock());
  }
}
