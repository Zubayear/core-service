package com.lucienvirecourt.coreservice.adapter.in.security;

import java.util.Collection;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class GatewayAuthenticationToken extends AbstractAuthenticationToken {
  private final GatewayPrincipal principal;

  public GatewayAuthenticationToken(
      GatewayPrincipal principal, @Nullable Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    setAuthenticated(true);
  }

  @Override
  public @Nullable Object getCredentials() {
    return null;
  }

  @Override
  public @Nullable Object getPrincipal() {
    return principal;
  }
}
