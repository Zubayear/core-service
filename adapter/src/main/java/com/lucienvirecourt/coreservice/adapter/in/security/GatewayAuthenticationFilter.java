package com.lucienvirecourt.coreservice.adapter.in.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class GatewayAuthenticationFilter extends OncePerRequestFilter {
  private static final String HEADER_USER_ID = "X-Consumer-Custom-Id";
  private static final String HEADER_USERNAME = "X-Consumer-Username";
  private static final String HEADER_TENANT = "X-Tenant-Id";
  private static final String HEADER_ROLES = "X-User-Roles";

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String userId = request.getHeader(HEADER_USER_ID);
    String username = request.getHeader(HEADER_USERNAME);
    String tenantId = request.getHeader(HEADER_TENANT);
    String rolesHeader = request.getHeader(HEADER_ROLES);

    if (userId != null) {
      List<String> roles =
          rolesHeader != null ? Arrays.asList(rolesHeader.split(",")) : Collections.emptyList();

      var authorities = roles.stream().map(String::trim).map(SimpleGrantedAuthority::new).toList();

      var principal = new GatewayPrincipal(userId, username, tenantId, roles);
      var authentication = new GatewayAuthenticationToken(principal, authorities);

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }
}
