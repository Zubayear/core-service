package com.lucienvirecourt.coreservice.adapter.in.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class RequestLoggingFilter extends OncePerRequestFilter {
  private static final Logger log = LogManager.getLogger(RequestLoggingFilter.class);

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    long startTime = System.nanoTime();

    log.info(
        ">>> {} {} from {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr());

    try {
      filterChain.doFilter(request, response);
    } finally {
      long duration = (System.nanoTime() - startTime) / 1_000_000;

      log.info(
          "<<< {} {} → {} duration({}ms)",
          request.getMethod(),
          request.getRequestURI(),
          response.getStatus(),
          duration);
    }
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return request.getRequestURI().startsWith("/actuator");
  }
}
