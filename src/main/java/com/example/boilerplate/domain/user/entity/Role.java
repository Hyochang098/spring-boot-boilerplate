package com.example.boilerplate.domain.user.entity;

public enum Role {
  USER,
  ADMIN;

  public String authority() {
    return "ROLE_" + name();
  }
}
