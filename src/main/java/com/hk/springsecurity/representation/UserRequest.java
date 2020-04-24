package com.hk.springsecurity.representation;

import com.hk.springsecurity.domain.Role;
import com.hk.springsecurity.domain.User;

public class UserRequest {
    private String name;
    private String email;
    private String pasword;
    private Role role;

    public UserRequest(String name, String email, String pasword, Role role) {
        this.name = name;
        this.email = email;
        this.pasword = pasword;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasword() {
        return pasword;
    }

    public Role getRole() {
        return role;
    }
}
