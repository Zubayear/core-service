package com.lucienvirecourt.coreservice;

import com.lucienvirecourt.coreservice.application.port.in.cart.AddToCartUseCase;
import com.lucienvirecourt.coreservice.application.port.in.cart.EmptyCartUseCase;
import com.lucienvirecourt.coreservice.application.port.in.cart.GetCartUseCase;
import com.lucienvirecourt.coreservice.application.port.in.product.FindProductsUseCase;
import com.lucienvirecourt.coreservice.application.port.in.security.CurrentUserPort;
import com.lucienvirecourt.coreservice.application.port.out.persistence.CartRepository;
import com.lucienvirecourt.coreservice.application.port.out.persistence.ProductRepository;
import com.lucienvirecourt.coreservice.application.service.cart.AddToCartService;
import com.lucienvirecourt.coreservice.application.service.cart.EmptyCartService;
import com.lucienvirecourt.coreservice.application.service.cart.GetCartService;
import com.lucienvirecourt.coreservice.application.service.product.FindProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring application configuration, making Spring beans from services defined in application
 * module.
 *
 * @author Syed Ibna Zubaeyar
 */
@SpringBootApplication
public class SpringAppConfig {

  @Autowired CartRepository cartRepository;

  @Autowired ProductRepository productRepository;

  @Autowired CurrentUserPort currentUserPort;

  @Bean
  GetCartUseCase getCartUseCase() {
    return new GetCartService(cartRepository);
  }

  @Bean
  EmptyCartUseCase emptyCartUseCase() {
    return new EmptyCartService(cartRepository);
  }

  @Bean
  FindProductsUseCase findProductsUseCase() {
    return new FindProductsService(productRepository);
  }

  @Bean
  AddToCartUseCase addToCartUseCase() {
    return new AddToCartService(cartRepository, productRepository, currentUserPort);
  }
}
