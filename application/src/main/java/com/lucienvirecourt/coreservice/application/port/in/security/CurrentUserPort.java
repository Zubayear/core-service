package com.lucienvirecourt.coreservice.application.port.in.security;

public interface CurrentUserPort {
    String getUserId();
    String getTenantId();
    boolean hasRole(String role);
}
