package com.arquitetura.Model.Enum;

public enum Role {
    ADMIN("admin"),
    USERS("user");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
