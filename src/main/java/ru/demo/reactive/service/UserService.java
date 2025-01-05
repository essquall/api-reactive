package ru.demo.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.demo.reactive.model.User;
import ru.demo.reactive.repository.UserMemoryRepository;

@Service
public class UserService {

    private final UserMemoryRepository userMemoryRepository;

    public UserService(UserMemoryRepository userMemoryRepository) {
        this.userMemoryRepository = userMemoryRepository;
    }

    public Mono<User> getUser(long id) {
        return userMemoryRepository.findById(id);
    }

    public Flux<User> getUsers() {
        return userMemoryRepository.findAll();
    }

    public Flux<User> getSublistUsers(long start, long count) {
        return userMemoryRepository.sublist(start, count);
    }
}
