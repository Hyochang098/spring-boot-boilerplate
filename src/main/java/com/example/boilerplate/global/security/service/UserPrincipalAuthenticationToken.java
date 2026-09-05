package com.example.boilerplate.global.security.service;

import com.example.boilerplate.global.security.UserPrincipal;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {

  private final UserPrincipal principal;

  public UserPrincipalAuthenticationToken(UserPrincipal principal) {
    super(principal.getAuthorities());
    this.principal = principal;
    setAuthenticated(true);
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

  @Override
  public Object getCredentials() {
    return null;
  }
}
