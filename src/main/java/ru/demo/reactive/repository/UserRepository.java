package ru.demo.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.demo.reactive.model.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
