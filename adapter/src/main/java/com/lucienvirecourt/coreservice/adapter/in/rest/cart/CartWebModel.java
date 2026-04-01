package com.lucienvirecourt.coreservice.adapter.in.rest.cart;

import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.money.Money;
import java.util.List;

/**
 * Model class for returning a shopping cart via REST API.
 *
 * @author Syed Ibna Zubaeyar
 */
public record CartWebModel(
    List<CartLineItemWebModel> lineItems, int numberOfItems, Money subTotal) {

  static CartWebModel fromDomainModel(Cart cart) {
    return new CartWebModel(
        cart.lineItems().stream().map(CartLineItemWebModel::fromDomainModel).toList(),
        cart.numberOfItems(),
        cart.subTotal());
  }
}
