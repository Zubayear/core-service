package com.lucienvirecourt.coreservice.adapter.in.rest.cart;

import static com.lucienvirecourt.coreservice.adapter.in.rest.common.CustomerIdParser.parseCustomerId;

import com.lucienvirecourt.coreservice.application.port.in.cart.GetCartUseCase;
import com.lucienvirecourt.coreservice.model.cart.Cart;
import com.lucienvirecourt.coreservice.model.customer.CustomerId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for all shopping cart use cases.
 *
 * @author Syed Ibna Zubaeyar
 */
@RestController
@RequestMapping("/carts")
public class GetCartController {

  private final GetCartUseCase getCartUseCase;

  public GetCartController(GetCartUseCase getCartUseCase) {
    this.getCartUseCase = getCartUseCase;
  }

  @GetMapping("/{customerId}")
  public CartWebModel getCart(@PathVariable("customerId") String customerIdString) {
    CustomerId customerId = parseCustomerId(customerIdString);
    Cart cart = getCartUseCase.getCart(customerId);
    return CartWebModel.fromDomainModel(cart);
  }
}
