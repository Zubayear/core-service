package com.lucienvirecourt.coreservice.adapter.in.security;

import java.util.List;

public record GatewayPrincipal(
   String userId,
   String username,
   String tenantId,
   List<String> roles
) {}
