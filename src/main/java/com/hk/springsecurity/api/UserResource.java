package com.hk.springsecurity.api;

import com.hk.springsecurity.domain.User;
import com.hk.springsecurity.representation.UserRequest;
import com.hk.springsecurity.representation.UserResponse;
import com.hk.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request){
        User addedUser = userService.add(User.fromRequest(request));
        if(Objects.nonNull(addedUser))
            return ResponseEntity.status(HttpStatus.CREATED).body(addedUser.toResponse());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAll(){
        List<User> all = userService.getAll();
        if(Objects.nonNull(all))
            return ResponseEntity.status(HttpStatus.OK).body(all);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
