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

        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encrypted);

        userRepository.save(user);
    }

    private String encryptPassword(String password) {
        return password;
    }
}
