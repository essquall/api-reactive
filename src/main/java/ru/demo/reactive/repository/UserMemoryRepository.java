package ru.demo.reactive.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.demo.reactive.model.User;

@Repository
public class UserMemoryRepository {

    private static Flux<User> users = Flux.just(
            new User(10L, "Tank", 22),
            new User(30L, "David", 24),
            new User(20L, "Nik", 22),
            new User(40L, "Ivan", 24),
            new User(29L, "Denis", 21),
            new User(22L, "Kira", 29));

    public Mono<User> findById(long id) {
        return users.filter(u -> u.getId() == id).next();
    }

    public Flux<User> findAll() {
        return users;
    }

    public Flux<User> sublist(long start, long count) {
        return users.skip(start).take(count);
    }
}
