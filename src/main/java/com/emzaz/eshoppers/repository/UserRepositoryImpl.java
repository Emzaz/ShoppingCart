package com.emzaz.eshoppers.repository;

import com.emzaz.eshoppers.domain.User;
import com.emzaz.eshoppers.dtos.UserDTO;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class UserRepositoryImpl implements UserRepository{
    private static final Set<User> USERS = new CopyOnWriteArraySet<>();

    @Override
    public void save(User user) {
        USERS.add(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        for(User user: USERS) {
            if(Objects.equals(user.getUserName(), username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        for(User user : USERS) {
            if(Objects.equals(user.getEmail(), email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        for(User user : USERS) {
            if(Objects.equals(user.getFirstName(), firstName)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        for(User user : USERS) {
            if(Objects.equals(user.getLastName(), lastName)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
