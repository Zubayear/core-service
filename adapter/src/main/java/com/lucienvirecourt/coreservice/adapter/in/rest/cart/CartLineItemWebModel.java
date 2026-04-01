package com.lucienvirecourt.coreservice.adapter.in.rest.cart;

import com.lucienvirecourt.coreservice.model.cart.CartLineItem;
import com.lucienvirecourt.coreservice.model.money.Money;
import com.lucienvirecourt.coreservice.model.product.Product;

/**
 * Model class for returning a shopping cart line item via REST API.
 *
 * @author Syed Ibna Zubaeyar
 */
public record CartLineItemWebModel(
    String productId, String productName, Money price, int quantity) {

  public static CartLineItemWebModel fromDomainModel(CartLineItem lineItem) {
    Product product = lineItem.product();
    return new CartLineItemWebModel(
        product.id().value(), product.name(), product.price(), lineItem.quantity());
  }
}
