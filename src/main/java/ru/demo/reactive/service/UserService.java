package ru.demo.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.demo.reactive.model.User;
import ru.demo.reactive.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }
}
