package com.emzaz.eshoppers.service;

import com.emzaz.eshoppers.domain.User;
import com.emzaz.eshoppers.dtos.LoginDTO;
import com.emzaz.eshoppers.dtos.UserDTO;

public interface UserService {
    void saveUser(UserDTO userDTO);

    boolean isNotUniqueUsername(UserDTO userDTO);
    boolean isNotUniqueEmail(UserDTO userDTO);
    boolean isNotUniqueFirstName(UserDTO userDTO);
    boolean isNotUniqueLastName(UserDTO userDTO);

    User verifyUser(LoginDTO loginDTO);
}
