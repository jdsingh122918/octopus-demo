package dev.fermatsolutions;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

@Repository
public interface UserRepository extends ReactorCrudRepository<User, Long> {
}
