package com.lucienvirecourt.coreservice.adapter.in.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MdcFilter extends OncePerRequestFilter {
  private static final String HEADER_REQUEST_ID = "X-Request-Id";
  private static final String HEADER_CORRELATION_ID = "X-Correlation-Id";
  private static final String HEADER_USER_ID = "X-Consumer-Custom-Id";
  private static final String HEADER_TENANT_ID = "X-Tenant-Id";

  private static final String MDC_CORRELATION_ID = "correlationId";
  private static final String MDC_USER_ID = "userId";
  private static final String MDC_TENANT_ID = "tenantId";
  private static final String MDC_REQUEST_METHOD = "httpMethod";
  private static final String MDC_REQUEST_URI = "httpUri";

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    try {
      // Correlation ID: prefer APISIX header, fallback to generated UUID
      String correlationId = request.getHeader(HEADER_CORRELATION_ID);
      if (correlationId == null) {
        correlationId = request.getHeader(HEADER_REQUEST_ID);
      }
      if (correlationId == null) {
        correlationId = UUID.randomUUID().toString();
      }

      MDC.put(MDC_CORRELATION_ID, correlationId);
      MDC.put(MDC_REQUEST_METHOD, request.getMethod());
      MDC.put(MDC_REQUEST_URI, request.getRequestURI());

      // User context (may be null at this point, filled later by security filter)
      String userId = request.getHeader(HEADER_USER_ID);
      if (userId != null) {
        MDC.put(MDC_USER_ID, userId);
      }

      String tenantId = request.getHeader(HEADER_TENANT_ID);
      if (tenantId != null) {
        MDC.put(MDC_TENANT_ID, tenantId);
      }

      // Pass correlation ID back in response for traceability
      response.setHeader(HEADER_CORRELATION_ID, correlationId);

      filterChain.doFilter(request, response);
    } finally {
      MDC.clear(); // CRITICAL: prevent leaking between requests
    }
  }
}
