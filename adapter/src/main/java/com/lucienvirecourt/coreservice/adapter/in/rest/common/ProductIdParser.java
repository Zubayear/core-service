package com.lucienvirecourt.coreservice.adapter.in.rest.common;

import static com.lucienvirecourt.coreservice.adapter.in.rest.common.ControllerCommons.clientErrorException;

import com.lucienvirecourt.coreservice.model.product.ProductId;
import org.springframework.http.HttpStatus;

/**
 * A parser for product IDs, throwing a {@link
 * org.springframework.web.client.HttpClientErrorException} for invalid product IDs.
 *
 * @author Syed Ibna Zubaeyar
 */
public final class ProductIdParser {

  private ProductIdParser() {}

  public static ProductId parseProductId(String string) {
    if (string == null) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, "Missing 'productId'");
    }

    try {
      return new ProductId(string);
    } catch (IllegalArgumentException e) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, "Invalid 'productId'");
    }
  }
}
