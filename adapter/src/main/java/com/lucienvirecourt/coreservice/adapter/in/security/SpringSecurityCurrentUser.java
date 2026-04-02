package com.lucienvirecourt.coreservice.adapter.in.security;

import com.lucienvirecourt.coreservice.application.port.in.security.CurrentUserPort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityCurrentUser implements CurrentUserPort {

  private GatewayPrincipal getPrincipal() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof GatewayAuthenticationToken token) {
      return (GatewayPrincipal) token.getPrincipal();
    }
    throw new IllegalStateException("No gateway authentication found");
  }

  @Override
  public String getUserId() {
    return getPrincipal().userId();
  }

  @Override
  public String getTenantId() {
    return getPrincipal().tenantId();
  }

  @Override
  public boolean hasRole(String role) {
    return getPrincipal().roles().contains(role);
  }
}
