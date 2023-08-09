package com.vincenzo.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // GET /users
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User returnedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(returnedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
