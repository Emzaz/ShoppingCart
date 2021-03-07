package com.emzaz.eshoppers.service;

import com.emzaz.eshoppers.domain.User;
import com.emzaz.eshoppers.dtos.UserDTO;
import com.emzaz.eshoppers.repository.UserRepository;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        String encrypted = encryptPassword(userDTO.getPassword());
        User user = new User();

        user.setUserName(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encrypted);

        userRepository.save(user);
    }

    @Override
    public boolean isNotUniqueUsername(UserDTO user) {
        return userRepository.findByUsername(user.getUsername()).isPresent();
    }

    @Override
    public boolean isNotUniqueEmail(UserDTO user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    @Override
    public boolean isNotUniqueFirstName(UserDTO user) {
        return userRepository.findByFirstName(user.getFirstName()).isPresent();
    }

    @Override
    public boolean isNotUniqueLastName(UserDTO user) {
        return userRepository.findByLastName(user.getLastName()).isPresent();
    }

    private String encryptPassword(String password) {
        return password;
    }
}
