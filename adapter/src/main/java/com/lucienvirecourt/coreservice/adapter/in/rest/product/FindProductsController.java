package com.lucienvirecourt.coreservice.adapter.in.rest.product;

import static com.lucienvirecourt.coreservice.adapter.in.rest.common.ControllerCommons.clientErrorException;

import com.lucienvirecourt.coreservice.application.port.in.product.FindProductsUseCase;
import com.lucienvirecourt.coreservice.model.product.Product;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for all product use cases.
 *
 * @author Syed Ibna Zubaeyar
 */
@RestController
@RequestMapping("/products")
public class FindProductsController {

  private final FindProductsUseCase findProductsUseCase;

  public FindProductsController(FindProductsUseCase findProductsUseCase) {
    this.findProductsUseCase = findProductsUseCase;
  }

  @GetMapping
  public List<ProductInListWebModel> findProducts(
      @RequestParam(value = "query", required = false) String query) {
    if (query == null) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, "Missing 'query'");
    }

    List<Product> products;

    try {
      products = findProductsUseCase.findByNameOrDescription(query);
    } catch (IllegalArgumentException e) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, "Invalid 'query'");
    }

    return products.stream().map(ProductInListWebModel::fromDomainModel).toList();
  }
}
