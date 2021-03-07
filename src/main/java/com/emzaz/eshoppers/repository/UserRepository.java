package com.emzaz.eshoppers.repository;

import com.emzaz.eshoppers.domain.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
}
