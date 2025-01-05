package ru.demo.reactive.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.demo.reactive.model.User;
import ru.demo.reactive.service.UserService;

@RestController
@RequestMapping("reactive/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = "application/stream+json")
    public Flux<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/users/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "/users")
    public Mono<User> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
