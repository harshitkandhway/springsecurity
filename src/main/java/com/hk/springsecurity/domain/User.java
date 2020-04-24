package com.hk.springsecurity.domain;

import com.hk.springsecurity.representation.UserRequest;
import com.hk.springsecurity.representation.UserResponse;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated
    private Role role;
    private String email;
    private String password;

    public static User fromRequest(UserRequest request){
        return new User.Builder()
                .withName(request.getName())
                .withEmail(request.getEmail())
                .withPassword(request.getPasword())
                .withRole(request.getRole())
                .build();
    }

    public UserResponse toResponse(){
        return new UserResponse(this.name,this.email,this.role);
    }

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        role = builder.role;
        email = builder.email;
        password = builder.password;
    }


    public static final class Builder {
        private int id;
        private String name;
        private Role role;
        private String email;
        private String password;

        public Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withRole(Role val) {
            role = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Role getRole() {
            return role;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
